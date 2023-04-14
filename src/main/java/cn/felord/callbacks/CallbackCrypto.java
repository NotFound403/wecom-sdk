package cn.felord.callbacks;

import cn.felord.domain.callback.CallbackSettings;
import cn.felord.domain.callback.CallbackEventBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
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
@Slf4j
public class CallbackCrypto {
    private static final String BOM = "\ufeff";
    private static final String MSG = "{\"encrypt\":\"%1$s\",\"msgsignature\":\"%2$s\",\"timestamp\":\"%3$s\",\"nonce\":\"%4$s\"}";
    private final XmlReader xmlReader;
    private final CallbackAsyncConsumer callbackAsyncConsumer;
    private final CallbackSettingsService callbackSettingsService;


    /**
     * 构造函数
     *
     * @param xmlReader               the xml reader
     * @param callbackSettingsService the callback authentication service
     * @param callbackAsyncConsumer   the callback consumer
     * @throws WeComCallbackException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    CallbackCrypto(XmlReader xmlReader, CallbackSettingsService callbackSettingsService, CallbackAsyncConsumer callbackAsyncConsumer) {
        this.xmlReader = xmlReader;
        this.callbackSettingsService = callbackSettingsService;
        this.callbackAsyncConsumer = callbackAsyncConsumer;
    }

    /**
     * Get network bytes order byte [ ].
     *
     * @param sourceNumber the source number
     * @return the byte [ ]
     */
// 生成4个字节的网络字节序
    byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    /**
     * Recover network bytes order int.
     *
     * @param orderBytes the order bytes
     * @return the int
     */
// 还原4个字节的网络字节序
    int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * Gets random str.
     *
     * @return the random str
     */
// 随机生成16位字符串
    String getRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 对明文进行加密.
     *
     * @param receiveid the receiveid
     * @param aesKey    the aes key
     * @param randomStr the random str
     * @param text      需要加密的明文
     * @return 加密后base64编码的字符串 string
     * @throws WeComCallbackException aes加密失败
     */
    String encrypt(String receiveid, byte[] aesKey, String randomStr, String text) throws WeComCallbackException {
        ByteGroup byteCollector = new ByteGroup();
        byte[] randomStrBytes = randomStr.getBytes(StandardCharsets.UTF_8);
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);

        byte[] receiveidBytes = receiveid.getBytes(StandardCharsets.UTF_8);
        // randomStr + networkBytesOrder + text + receiveid
        byteCollector.addBytes(randomStrBytes);
        byteCollector.addBytes(networkBytesOrder);
        byteCollector.addBytes(textBytes);
        byteCollector.addBytes(receiveidBytes);
        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);
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
            throw new WeComCallbackException(WeComCallbackException.EncryptAESError);
        }
    }

    /**
     * 对密文进行解密.
     *
     * @param corpId the corp id
     * @param aesKey the aes key
     * @param text   需要解密的密文
     * @return 解密得到的明文 string
     * @throws WeComCallbackException aes解密失败
     */
    private String decrypt(String corpId, byte[] aesKey, String text) throws WeComCallbackException {
        byte[] original;
        try {
            // 设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec spec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, spec, iv);

            // 使用BASE64对密文进行解码
            byte[] encrypted = Base64.decodeBase64(text);

            // 解密
            original = cipher.doFinal(encrypted);
        } catch (Exception e) {
            throw new WeComCallbackException(WeComCallbackException.DecryptAESError);
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
            throw new WeComCallbackException(WeComCallbackException.IllegalBuffer);
        }

        // receiveid不相同的情况
        if (!Objects.equals(corpId, fromReceiveid)) {
            throw new WeComCallbackException(WeComCallbackException.ValidateCorpidError);
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
     * @throws WeComCallbackException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    public String encryptJsonMsg(String agentId, String corpId, String replyMsg, String timeStamp, String nonce) throws WeComCallbackException {
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        // 加密
        String receiveid = callbackSettings.getReceiveid();
        String encrypt = this.encrypt(receiveid, callbackSettings.getAesKey(), getRandomStr(), replyMsg);
        // 生成安全签名
        if (!StringUtils.hasText(timeStamp)) {
            timeStamp = Long.toString(System.currentTimeMillis());
        }
        String token = callbackSettings.getToken();
        String signature = SHA1.sha1Hex(token, timeStamp, nonce, encrypt);
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
     * @throws WeComCallbackException the we com callback exception
     */
    public String encryptXmlMsg(String agentId, String corpId, String replyMsg, String timeStamp, String nonce) throws WeComCallbackException {
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        // 加密
        String receiveid = callbackSettings.getReceiveid();
        String encrypt = this.encrypt(receiveid, callbackSettings.getAesKey(), getRandomStr(), replyMsg);
        // 生成安全签名
        if (!StringUtils.hasText(timeStamp)) {
            timeStamp = Long.toString(Instant.now().toEpochMilli());
        }
        String token = callbackSettings.getToken();
        String signature = SHA1.sha1Hex(token, timeStamp, nonce, encrypt);
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
     * @param <T>          the type parameter
     * @param agentId      the agent id
     * @param corpId       the corp id
     * @param msgSignature the msg signature
     * @param timeStamp    the time stamp
     * @param nonce        the nonce
     * @param xmlBody      the xml body
     * @param response     the response
     * @return the string
     * @throws WeComCallbackException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    public <T> T doAccept(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String xmlBody, T response) throws WeComCallbackException {
        CallbackXmlBody callbackXmlBody = xmlReader.read(xmlBody, CallbackXmlBody.class);
        String encrypt = callbackXmlBody.getEncrypt();
        String callbackAgentId = callbackXmlBody.getAgentId();
        String callbackCorpId = callbackXmlBody.getToUserName();
        if (Objects.equals(agentId, callbackAgentId) && Objects.equals(corpId, callbackCorpId)) {
            String xml = this.decryptMsg(agentId, corpId, msgSignature, timeStamp, nonce, encrypt);
            CallbackEventBody eventBody = xmlReader.read(xml, CallbackEventBody.class);
            eventBody.setAgentId(agentId);
            this.callbackAsyncConsumer.asyncAction(eventBody);
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Callback Agent is not matched");
            }
        }
        return response;
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
     * @param response     the response
     * @return the string
     * @throws WeComCallbackException the we com callback exception
     */
    public String accept(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String xmlBody, String response) throws WeComCallbackException {
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
     * @throws WeComCallbackException the we com callback exception
     */
    public String accept(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String xmlBody) throws WeComCallbackException {
        return this.doAccept(agentId, corpId, msgSignature, timeStamp, nonce, xmlBody, "success");
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
     * @throws WeComCallbackException the we com callback exception
     */
    public String decryptMsg(String agentId, String corpId, String msgSignature, String timeStamp, String nonce, String encrypt) throws WeComCallbackException {
        CallbackSettings callbackSettings = this.callbackSettingsService.loadAuthentication(agentId, corpId);
        String token = callbackSettings.getToken();
        String signature = SHA1.sha1Hex(token, timeStamp, nonce, encrypt);
        if (!Objects.equals(msgSignature, signature)) {
            log.info("signature not matched: before: {},after : {}", msgSignature, signature);
            throw new WeComCallbackException(WeComCallbackException.ValidateSignatureError);
        }
        byte[] aesKey = callbackSettings.getAesKey();
        return this.decrypt(corpId, aesKey, encrypt);
    }
}