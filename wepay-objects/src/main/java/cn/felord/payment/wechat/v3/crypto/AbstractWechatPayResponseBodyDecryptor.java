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

package cn.felord.payment.wechat.v3.crypto;

import cn.felord.payment.PayException;
import cn.felord.utils.Assert;
import cn.felord.utils.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author dax
 * @since 2023/8/7
 */
public class AbstractWechatPayResponseBodyDecryptor implements WechatPayResponseBodyDecryptor {
    private final CipherAlg cipherAlg;


    public AbstractWechatPayResponseBodyDecryptor(CipherAlg cipherAlg) {
        this.cipherAlg = cipherAlg;

    }


    @Override
    public String decrypt(String appV3Secret, String associatedData, String nonce, String cipherText) throws PayException {
        try {
            Assert.hasText(associatedData, "associatedData is invalid");
            Assert.hasText(nonce, "nonce is invalid");
            Assert.hasText(cipherText, "ciphertext is invalid");
        } catch (Exception e) {
            throw new PayException(e.getMessage());
        }

        try {
            Cipher cipher = Cipher.getInstance(cipherAlg.transformation());

            SecretKeySpec key = new SecretKeySpec(appV3Secret.getBytes(StandardCharsets.UTF_8), cipherAlg.alg());
            GCMParameterSpec spec = new GCMParameterSpec(128, nonce.getBytes(StandardCharsets.UTF_8));
            cipher.init(2, key, spec);
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));

            byte[] bytes;
            try {
                bytes = cipher.doFinal(Base64Utils.decodeFromString(cipherText));
            } catch (GeneralSecurityException var11) {
                throw new PayException(var11);
            }

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
            throw new PayException("Error When Decrypt Response Body", e);
        }
    }
}
