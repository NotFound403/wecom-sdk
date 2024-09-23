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

package cn.felord.payment.wechat.v3.crypto;

import cn.felord.utils.Assert;
import cn.felord.utils.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 默认敏感信息加密解密工具
 *
 * @author dax
 * @since 2024/8/7
 */
public class DefaultWecomCipher implements WecomCipher {
    private final CipherAlg cipherAlg;


    /**
     * Instantiates a new Abstract wecom cipher.
     *
     * @param cipherAlg the cipher alg
     */
    DefaultWecomCipher(CipherAlg cipherAlg) {
        this.cipherAlg = cipherAlg;

    }

    @Override
    public String encrypt(String key, String associatedData, String iv, String plainText) throws IllegalArgumentException {
        Assert.hasText(key, "key is invalid");
        Assert.hasText(associatedData, "associatedData is invalid");
        Assert.hasText(iv, "iv is invalid");
        Assert.hasText(plainText, "plainText is invalid");
        try {
            Cipher cipher = Cipher.getInstance(cipherAlg.transformation());
            cipher.init(
                    javax.crypto.Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), cipherAlg.alg()),
                    new GCMParameterSpec(cipherAlg.tagLength(), iv.getBytes(StandardCharsets.UTF_8)));
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
            return Base64Utils.encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidKeyException
                 | InvalidAlgorithmParameterException
                 | BadPaddingException
                 | IllegalBlockSizeException
                 | NoSuchAlgorithmException
                 | NoSuchPaddingException e) {
            throw new IllegalArgumentException("Error When Encrypt", e);
        }
    }

    @Override
    public String decrypt(String key, String associatedData, String iv, String cipherText) throws IllegalArgumentException {

        Assert.hasText(key, "key is invalid");
        Assert.hasText(associatedData, "associatedData is invalid");
        Assert.hasText(iv, "iv is invalid");
        Assert.hasText(cipherText, "cipherText is invalid");
        try {
            Cipher cipher = Cipher.getInstance(cipherAlg.transformation());
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), cipherAlg.alg());
            GCMParameterSpec spec = new GCMParameterSpec(cipherAlg.tagLength(), iv.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, spec);
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = cipher.doFinal(Base64Utils.decodeFromString(cipherText));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Error When Decrypt", e);
        }
    }
}
