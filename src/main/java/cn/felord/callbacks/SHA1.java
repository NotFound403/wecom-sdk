/**
 * 对企业微信发送给企业后台的消息加解密示例代码.
 *
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package cn.felord.callbacks;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * SHA1 class
 * <p>
 * 计算消息签名接口.
 */
final class SHA1 {
    private static final MessageDigest SHA1 = DigestUtils.getSha1Digest();

    private SHA1() {
    }

    /**
     * 用SHA1算法生成安全签名
     *
     * @param token     票据
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @param encrypt   密文
     * @return 安全签名 sha 1
     * @throws WeComCallbackException the aes exception
     */
    public static String sha1Hex(String token, String timestamp, String nonce, String encrypt) throws WeComCallbackException {
        try {
            String str = Stream.of(token, timestamp, nonce, encrypt)
                    .sorted()
                    .collect(Collectors.joining());
            return Hex.encodeHexString(SHA1.digest(str.getBytes()));
        } catch (Exception e) {
            throw new WeComCallbackException(WeComCallbackException.ComputeSignatureError);
        }
    }
}
