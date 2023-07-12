/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.callbacks;

import cn.felord.WeComException;
import cn.felord.domain.callback.CallbackEventBody;
import cn.felord.domain.callback.CallbackResource;
import cn.felord.domain.corpay.miniapppay.callback.RefundCallbackData;
import cn.felord.domain.corpay.miniapppay.callback.TransactionCallbackData;
import cn.felord.enumeration.CallbackEvent;
import cn.felord.enumeration.PayCallbackEventType;
import cn.felord.json.JacksonObjectMapperFactory;
import cn.felord.utils.Algorithms;
import cn.felord.utils.Base64Utils;
import cn.felord.utils.StringUtils;
import cn.felord.xml.XmlReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * 提供接收和推送给企业微信消息的加解密接口(UTF8编码的字符串).
 * <ol>
 * 	<li>第三方回复加密消息给企业微信</li>
 * 	<li>第三方收到企业微信发送的消息，验证消息的安全性，并对消息进行解密。</li>
 * </ol>
 * 说明：异常java.security.InvalidKeyException:illegal Key Size的解决方案
 * <ol>
 * 	<li>在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
 *      <a href="http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html">...</a></li>
 * 	<li>下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt</li>
 * 	<li>如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件</li>
 * 	<li>如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件</li>
 * </ol>
 */
public class CallbackCrypto {
    private static final String BOM = "\ufeff";
    private static final String BASE_ = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String MSG = "{\"encrypt\":\"%1$s\",\"msgsignature\":\"%2$s\",\"timestamp\":\"%3$s\",\"nonce\":\"%4$s\"}";
    private static final Random RANDOM = new SecureRandom();
    private static final ObjectMapper MAPPER = JacksonObjectMapperFactory.create();

    private final XmlReader xmlReader;
    private final CallbackAsyncConsumer callbackAsyncConsumer;
    private final CallbackSettingsService callbackSettingsService;


    /**
     * 构造函数
     *
     * @param xmlReader               the xml reader
     * @param callbackSettingsService the callback authentication service
     * @param callbackAsyncConsumer   the callback consumer
     * @throws WeComException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    CallbackCrypto(XmlReader xmlReader, CallbackSettingsService callbackSettingsService, CallbackAsyncConsumer callbackAsyncConsumer) {
        this.xmlReader = xmlReader;
        this.callbackSettingsService = callbackSettingsService;
        this.callbackAsyncConsumer = callbackAsyncConsumer;
    }

    /**
     * 生成4个字节的网络字节序
     *
     * @param sourceNumber the source number
     * @return the byte [ ]
     */
    byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    /**
     * 还原4个字节的网络字节序
     *
     * @param orderBytes the order bytes
     * @return the int
     */
    int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * 随机生成16位字符串
     *
     * @return the random str
     */
    String randomStr() {
        return RANDOM.ints(16, 0, BASE_.length())
                .mapToObj(BASE_::charAt)
                .collect(StringBuffer::new,
                        StringBuffer::append,
                        StringBuffer::append)
                .toString();

    }

    /**
     * 对明文进行加密.
     *
     * @param receiveid the receiveid
     * @param aesKey    the aes key
     * @param randomStr the random str
     * @param text      需要加密的明文
     * @return 加密后base64编码的字符串 string
     * @throws WeComException aes加密失败
     */
    String encrypt(String receiveid, byte[] aesKey, String randomStr, String text) throws WeComException {

        byte[] randomStrBytes = randomStr.getBytes(StandardCharsets.UTF_8);
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
        byte[] receiveidBytes = receiveid.getBytes(StandardCharsets.UTF_8);
        int byteSize = receiveidBytes.length + textBytes.length + networkBytesOrder.length + receiveidBytes.length;
        ByteCollector byteCollector = new ByteCollector()
                .addBytes(randomStrBytes)
                .addBytes(networkBytesOrder)
                .addBytes(textBytes)
                .addBytes(receiveidBytes)
                .addBytes(PKCS7Encoder.encode(byteSize));
        // 获得最终的字节流, 未加密
        byte[] unencrypted = byteCollector.toBytes();
        try {
            // 设置加密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            // 加密
            byte[] encrypted = cipher.doFinal(unencrypted);
            return Base64Utils.encodeToString(encrypted);
        } catch (Exception e) {
            throw new WeComException("error when encrypt with AES");
        }
    }

    /**
     * 对密文进行解密.
     *
     * @param corpId the corp id
     * @param aesKey the aes key
     * @param text   需要解密的密文
     * @return 解密得到的明文 string
     * @throws WeComException aes解密失败
     */
    private String decrypt(String corpId, byte[] aesKey, String text) throws WeComException {
        byte[] original;
        try {
            // 设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec spec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, spec, iv);
            // 解密
            original = cipher.doFinal(Base64Utils.decodeFromString(text));
        } catch (Exception e) {
            throw new WeComException("error when decrypt with AES");
        }

        String jsonContent, fromReceiveid;
        try {
            // 去除 补位 字符
            byte[] bytes = PKCS7Encoder.decode(original);
            // 分离16位随机字符串,网络字节序和receiveid
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int jsonLength = recoverNetworkBytesOrder(networkOrder);
            jsonContent = new String(Arrays.copyOfRange(bytes, 20, 20 + jsonLength), StandardCharsets.UTF_8);
            fromReceiveid = new String(Arrays.copyOfRange(bytes, 20 + jsonLength, bytes.length), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new WeComException("invalid buffer when callback decrypted");
        }

        // receiveid不相同的情况
        if (!Objects.equals(corpId, fromReceiveid)) {
            throw new WeComException(" invalid corpid");
        }
        return jsonContent.startsWith(BOM) ? jsonContent.substring(1) : jsonContent;
    }

    /**
     * 将企业微信回复用户的消息加密打包.
     * <ol>
     * 	<li>对要发送的消息进行AES-CBC加密</li>
     * 	<li>生成安全签名</li>
     * 	<li>将消息密文和安全签名打包成json格式</li>
     * </ol>
     *
     * @param agentId   the agent id
     * @param corpId    the corp id
     * @param replyMsg  企业微信待回复用户的消息，json格式的字符串
     * @param timeStamp 时间戳，可以自己生成，也可以用URL参数的timestamp
     * @param nonce     随机串，可以自己生成，也可以用URL参数的nonce
     * @return 加密后的可以直接回复用户的密文 ，包括msg_signature, timestamp, nonce, encrypt的json格式的字符串
     * @throws WeComException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    public String encryptJsonMsg(String agentId, String corpId, String replyMsg, String timeStamp, String nonce) throws WeComException {
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        // 加密
        String receiveid = callbackSettings.getReceiveid();
        String encrypt = this.encrypt(receiveid, callbackSettings.getAesKey(), randomStr(), replyMsg);
        // 生成安全签名
        if (!StringUtils.hasText(timeStamp)) {
            timeStamp = Long.toString(System.currentTimeMillis());
        }
        String token = callbackSettings.getToken();
        String signature = Algorithms.sha1Signature(token, timeStamp, nonce, encrypt);
        return String.format(MSG, encrypt, signature, timeStamp, nonce);
    }

    /**
     * Encrypt xml msg string.
     *
     * @param agentId   the agent id
     * @param corpId    the corp id
     * @param replyMsg  the reply msg
     * @param timeStamp the time stamp
     * @param nonce     the nonce
     * @return the string
     * @throws WeComException the we com callback exception
     */
    public String encryptXmlMsg(String agentId, String corpId, String replyMsg, String timeStamp, String nonce) throws WeComException {
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        // 加密
        String receiveid = callbackSettings.getReceiveid();
        String encrypt = this.encrypt(receiveid, callbackSettings.getAesKey(), randomStr(), replyMsg);
        // 生成安全签名
        if (!StringUtils.hasText(timeStamp)) {
            timeStamp = Long.toString(Instant.now().toEpochMilli());
        }
        String token = callbackSettings.getToken();
        String signature = Algorithms.sha1Signature(token, timeStamp, nonce, encrypt);
        CallbackXmlResponse callbackXmlResponse = new CallbackXmlResponse(encrypt, signature, timeStamp, nonce);
        return xmlReader.write(callbackXmlResponse);
    }

    /**
     * 检验XML消息的真实性，并且获取解密后的明文，用于消费回调数据，并自动响应POST回调请求.
     * <ol>
     * 	<li>利用收到的密文生成安全签名，进行签名验证</li>
     * 	<li>若验证通过，则提取json中的加密消息</li>
     * 	<li>对消息进行解密</li>
     * </ol>
     *
     * @param <R>          the type parameter
     * @param agentId      the agent id
     * @param corpId       the corp id
     * @param msgSignature the msg signature
     * @param timeStamp    the time stamp
     * @param nonce        the nonce
     * @param xmlBody      the xml body
     * @param response     the response
     * @return the response
     */
    public <R> R accept(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String xmlBody, R response) {
        return this.doAccept(agentId, corpId, msgSignature, timeStamp, nonce, xmlBody, response);
    }

    /**
     * Accept string.
     *
     * @param agentId      the agent id
     * @param corpId       the corp id
     * @param msgSignature the msg signature
     * @param timeStamp    the time stamp
     * @param nonce        the nonce
     * @param xmlBody      the xml body
     * @return the string
     * @throws WeComException the we com callback exception
     */
    public String accept(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String xmlBody) {
        return this.doAccept(agentId, corpId, msgSignature, timeStamp, nonce, xmlBody, "success");
    }

    private <T> T doAccept(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String xmlBody, T response) {
        CallbackXmlBody callbackXmlBody = xmlReader.read(xmlBody, CallbackXmlBody.class);
        String encrypt = callbackXmlBody.getEncrypt();
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        String xml = this.decryptMsg(callbackSettings, msgSignature, timeStamp, nonce, encrypt);
        CallbackEventBody eventBody = xmlReader.read(xml, CallbackEventBody.class);
        eventBody.setAgentId(agentId);
        // 唯一性判断
        eventBody.setMsgSignature(msgSignature);
        // begin 用来记录追踪
        eventBody.setTimeStamp(timeStamp);
        eventBody.setNonce(nonce);
        eventBody.setEncrypt(encrypt);
        eventBody.setXmlAgentId(callbackXmlBody.getAgentId());
        eventBody.setOriginalXml(xml);
        // end 用来记录追踪
        // begin 处理支付
        if (Objects.nonNull(eventBody.getResource())) {
            this.payCallback(eventBody, callbackSettings);
        }
        // end 处理支付
        this.callbackAsyncConsumer.asyncAction(eventBody);
        return response;
    }

    private void payCallback(CallbackEventBody eventBody, CallbackSettings callbackSettings) {
        CallbackResource resource = eventBody.getResource();
        String associatedData = resource.getAssociatedData();
        String nonce = resource.getNonce();
        String ciphertext = resource.getCiphertext();
        String json = Algorithms.aesDecode(callbackSettings.getAesKey(), associatedData, nonce, ciphertext);
        PayCallbackEventType eventType = eventBody.getEventType();

        if (Objects.equals(eventType, PayCallbackEventType.TRANSACTION_SUCCESS)) {
            try {
                TransactionCallbackData transactionCallbackData = MAPPER.readValue(json, TransactionCallbackData.class);
                eventBody.setTransactionCallbackData(transactionCallbackData);
            } catch (JsonProcessingException e) {
                throw new WeComException("pay transaction callback error on json conversion", e);
            }
        }
        if (Objects.equals(eventType, PayCallbackEventType.REFUND_CLOSED) ||
                Objects.equals(eventType, PayCallbackEventType.REFUND_ABNORMAL) ||
                Objects.equals(eventType, PayCallbackEventType.REFUND_SUCCESS)) {
            eventBody.setEvent(CallbackEvent.PAY_REFUND);
            try {
                RefundCallbackData refundCallbackData = MAPPER.readValue(json, RefundCallbackData.class);
                eventBody.setRefundCallbackData(refundCallbackData);
            } catch (JsonProcessingException e) {
                throw new WeComException("pay refund callback error on json conversion", e);
            }
        }
        eventBody.setMsgType("event");
    }

    /**
     * 解密验签，用于解密XML BODY以及校验回调URL真实性
     *
     * @param agentId      the agent id
     * @param corpId       the corp id
     * @param msgSignature the msg signature
     * @param timeStamp    the time stamp
     * @param nonce        the nonce
     * @param encrypt      to encrypt
     * @return the string
     * @throws WeComException the we com callback exception
     */
    public String decryptMsg(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String encrypt) {
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        return decryptMsg(callbackSettings, msgSignature, timeStamp, nonce, encrypt);
    }

    /**
     * Decrypt msg string.
     *
     * @param callbackSettings the callback settings
     * @param msgSignature     the msg signature
     * @param timeStamp        the time stamp
     * @param nonce            the nonce
     * @param encrypt          the encrypt
     * @return the string
     */
    public String decryptMsg(CallbackSettings callbackSettings, String msgSignature, String timeStamp, String nonce, String encrypt) {
        String token = callbackSettings.getToken();
        String signature = Algorithms.sha1Signature(token, timeStamp, nonce, encrypt);
        if (!Objects.equals(msgSignature, signature)) {
            throw new WeComException("callback signature not matched");
        }
        byte[] aesKey = callbackSettings.getAesKey();
        return this.decrypt(callbackSettings.getReceiveid(), aesKey, encrypt);
    }
}