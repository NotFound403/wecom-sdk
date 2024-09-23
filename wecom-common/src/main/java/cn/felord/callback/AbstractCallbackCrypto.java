/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.callback;

import cn.felord.utils.Algorithms;
import cn.felord.utils.Base64Utils;
import cn.felord.utils.StringUtils;
import cn.felord.xml.XmlReader;

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
 * 回调解密超类
 *
 * @param <EVENT> 解析后的事件明文
 */
public abstract class AbstractCallbackCrypto<EVENT> {
    private static final String BOM = "\ufeff";
    private static final String BASE_ = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String MSG = "{\"encrypt\":\"%1$s\",\"msgsignature\":\"%2$s\",\"timestamp\":\"%3$s\",\"nonce\":\"%4$s\"}";
    private static final Random RANDOM = new SecureRandom();
    private final XmlReader xmlReader;
    private final CallbackAsyncConsumer<EVENT> callbackAsyncConsumer;


    /**
     * 构造函数
     *
     * @param xmlReader             the xml reader
     * @param callbackAsyncConsumer the callback consumer
     */
    public AbstractCallbackCrypto(XmlReader xmlReader, CallbackAsyncConsumer<EVENT> callbackAsyncConsumer) {
        this.xmlReader = xmlReader;
        this.callbackAsyncConsumer = callbackAsyncConsumer;
    }

    /**
     * 对明文进行加密.
     *
     * @param receiveid the receiveid
     * @param aesKey    the aes key
     * @param randomStr the random str
     * @param text      需要加密的明文
     * @return 加密后base64编码的字符串 string
     * @throws IllegalArgumentException aes加密失败
     */
    public String encrypt(String receiveid, byte[] aesKey, String randomStr, String text) throws IllegalArgumentException {
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
            throw new IllegalArgumentException("error when encrypt with AES", e);
        }
    }

    /**
     * 对密文进行解密.
     *
     * @param aesKey the aes key
     * @param text   需要解密的密文
     * @return 解密得到的明文 string
     * @throws IllegalArgumentException aes解密失败
     */
    private CallbackDecrypted decrypt(byte[] aesKey, String text) throws IllegalArgumentException {
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
            throw new IllegalArgumentException("error when decrypt with AES", e);
        }
        try {
            // 去除 补位 字符
            byte[] bytes = PKCS7Encoder.decode(original);
            // 分离16位随机字符串,网络字节序和receiveid
            int to = 20;
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, to);
            int jsonLength = recoverNetworkBytesOrder(networkOrder);
            String jsonContent = new String(Arrays.copyOfRange(bytes, to, to + jsonLength), StandardCharsets.UTF_8);
            String fromReceiveid = new String(Arrays.copyOfRange(bytes, to + jsonLength, bytes.length), StandardCharsets.UTF_8);
            String content = jsonContent.startsWith(BOM) ? jsonContent.substring(1) : jsonContent;
            return new CallbackDecrypted(content, fromReceiveid);
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid buffer when callback decrypted", e);
        }

    }

    /**
     * 将企业微信回复用户的消息加密打包.
     * <ol>
     * 	<li>对要发送的消息进行AES-CBC加密</li>
     * 	<li>生成安全签名</li>
     * 	<li>将消息密文和安全签名打包成json格式</li>
     * </ol>
     *
     * @param callbackSettings the callback settings
     * @param replyMsg         企业微信待回复用户的消息，json格式的字符串
     * @param timeStamp        时间戳，可以自己生成，也可以用URL参数的timestamp
     * @param nonce            随机串，可以自己生成，也可以用URL参数的nonce
     * @return 加密后的可以直接回复用户的密文 ，包括msg_signature, timestamp, nonce, encrypt的json格式的字符串
     */
    public String encryptJsonMsg(CallbackSettings callbackSettings, String replyMsg, String timeStamp, String nonce) {
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
     * @param callbackSettings the callback settings
     * @param replyMsg         the reply msg
     * @param timeStamp        the time stamp
     * @param nonce            the nonce
     * @return the string
     */
    public String encryptXmlMsg(CallbackSettings callbackSettings, String replyMsg, String timeStamp, String nonce) {
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
     * Accept t.
     *
     * @param <T>       the type parameter
     * @param eventBody the event body
     * @param response  the response
     * @return the t
     */
    public <T> T accept(EVENT eventBody, T response) {
        // end 处理支付
        this.callbackAsyncConsumer.asyncAction(eventBody);
        return response;
    }


    /**
     * 解密验签，用于解密XML BODY以及校验回调URL真实性
     *
     * @param callbackSettings the callback settings
     * @param msgSignature     the msg signature
     * @param timeStamp        the time stamp
     * @param nonce            the nonce
     * @param encrypt          the encrypt
     * @return the callback decrypted
     */
    public CallbackDecrypted decrypt(CallbackSettings callbackSettings, String msgSignature, String timeStamp, String nonce, String encrypt) {
        String token = callbackSettings.getToken();
        String signature = Algorithms.sha1Signature(token, timeStamp, nonce, encrypt);
        if (!Objects.equals(msgSignature, signature)) {
            throw new IllegalArgumentException("callback signature not matched");
        }
        byte[] aesKey = callbackSettings.getAesKey();
        return this.decrypt(aesKey, encrypt);
    }

    /**
     * Read xml t.
     *
     * @param <T>     the type parameter
     * @param xmlBody the xml body
     * @param clazz   the clazz
     * @return the t
     */
    public <T extends XmlEntity> T readXml(String xmlBody, Class<T> clazz) {
        return this.xmlReader.read(xmlBody, clazz);
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

}
