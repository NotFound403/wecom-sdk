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

// ------------------------------------------------------------------------

package cn.felord.utils;

import cn.felord.callbacks.WeComCallbackException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * SHA1 class
 * <p>
 * 计算消息签名接口.
 */
public final class SHA1 {
    private static final MessageDigest SHA1;

    static {
        try {
            SHA1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

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
    public static String sha1Signature(String token, String timestamp, String nonce, String encrypt) throws WeComCallbackException {

        try {
            String str = Stream.of(token, timestamp, nonce, encrypt)
                    .sorted()
                    .collect(Collectors.joining());
            //todo sha1Hex?
            SHA1.update(str.getBytes());
            byte[] digest = SHA1.digest();
            StringBuilder hexstr = new StringBuilder();
            for (byte b : digest) {
                String shaHex = Integer.toHexString(b & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            throw new WeComCallbackException(WeComCallbackException.ComputeSignatureError);
        }
    }

    public static String sha1Hex(String format) {
        SHA1.update(format.getBytes());
        byte[] bytes = SHA1.digest();
        return Hex.encodeHexString(bytes);
    }

}
