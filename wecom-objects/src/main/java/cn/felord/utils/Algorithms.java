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

package cn.felord.utils;

import cn.felord.WeComException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Algorithms.
 *
 * @author dax
 * @since 2023 /6/25 13:56
 */
public final class Algorithms {

    private static final MessageDigest SHA1;
    private static final MessageDigest MD5;
    private static final Mac HMAC_SHA256;

    static {
        try {
            SHA1 = MessageDigest.getInstance("SHA-1");
            MD5 = MessageDigest.getInstance("MD5");
            HMAC_SHA256 = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new WeComException("algorithms init error", e);
        }
    }

    private Algorithms() {
    }

    /**
     * 用SHA1算法生成安全签名
     *
     * @param token     票据
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @param encrypt   密文
     * @return 安全签名 sha 1
     * @throws IllegalArgumentException the aes exception
     */
    public static String sha1Signature(String token, String timestamp, String nonce, String encrypt) throws IllegalArgumentException {
        try {
            String str = Stream.of(token, timestamp, nonce, encrypt)
                    .sorted()
                    .collect(Collectors.joining());
            return sha1Hex(str);
        } catch (Exception e) {
            throw new WeComException("SHA-1 signature error", e);
        }
    }

    /**
     * Sha1 hex.
     *
     * @param format the format
     * @return the string
     */
    public static String sha1Hex(String format) {
        SHA1.update(format.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = SHA1.digest();
        return Hex.encodeHexString(bytes);
    }

    /**
     * Hmac_sha256
     *
     * @param src       the src
     * @param secret    the secret
     * @param upperCase the upper case
     * @return the string
     */
    public static String hmacSha256Hex(String src, String secret, boolean upperCase) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256.getAlgorithm());
        try {
            HMAC_SHA256.init(secretKeySpec);
        } catch (InvalidKeyException e) {
            throw new WeComException("Hmac-sha256 encode error", e);
        }
        byte[] bytes = HMAC_SHA256.doFinal(src.getBytes(StandardCharsets.UTF_8));
        String encodeHexString = Hex.encodeHexString(bytes);
        return upperCase ? encodeHexString.toUpperCase() : encodeHexString;
    }

    /**
     * Md5 hex
     *
     * @param src       the src
     * @param upperCase the upper case
     * @return the string
     */
    public static String md5Hex(String src, boolean upperCase) {
        MD5.update(src.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = MD5.digest();
        String encodeHexString = Hex.encodeHexString(bytes);
        return upperCase ? encodeHexString.toUpperCase() : encodeHexString;
    }

}
