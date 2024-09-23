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

package cn.felord.utils;


import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Algorithms.
 *
 * @author dax
 * @since 2024/6/25 13:56
 */
public final class Algorithms {

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
            throw new IllegalArgumentException("SHA-1 signature error", e);
        }
    }

    /**
     * Sha1 hex.
     *
     * @param format the format
     * @return the string
     */
    public static String sha1Hex(String format) {
        final MessageDigest SHA1;
        try {
            SHA1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("algorithm sha-1 init error", e);
        }
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
        final Mac HMAC_SHA256;
        try {
            HMAC_SHA256 = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("algorithm hmac-sha256 init error", e);
        }

        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256.getAlgorithm());
        try {
            HMAC_SHA256.init(secretKeySpec);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("Hmac-sha256 encode error", e);
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
        return md5Hex(src.getBytes(StandardCharsets.UTF_8), upperCase);
    }

    /**
     * Md 5 hex string.
     *
     * @param src       the src
     * @param upperCase the upper case
     * @return the string
     */
    public static String md5Hex(byte[] src, boolean upperCase) {
        final MessageDigest MD5;
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("algorithm md5 init error", e);
        }
        MD5.update(src);
        byte[] bytes = MD5.digest();
        String encodeHexString = Hex.encodeHexString(bytes);
        return upperCase ? encodeHexString.toUpperCase() : encodeHexString;
    }

    /**
     * 解密响应体.
     *
     * @param aesKey         the aes key
     * @param associatedData the associated data
     * @param nonce          the nonce
     * @param ciphertext     the ciphertext
     * @return the string
     */
    public static String aesDecode(byte[] aesKey, String associatedData, String nonce, String ciphertext) {

        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
            GCMParameterSpec spec = new GCMParameterSpec(128, nonce.getBytes(StandardCharsets.UTF_8));

            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, spec);
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));

            byte[] bytes = cipher.doFinal(Base64Utils.decodeFromString(ciphertext));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new IllegalArgumentException("Aes decrypt error", e);
        }
    }

}
