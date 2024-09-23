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

import cn.felord.payment.PayException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * 从文件中加载商户KEY信息
 *
 * @author dax
 * @since 2024/8/4
 */
public class FileMerchantKeyLoader {
    private static final String TENPAY_ALIAS = "Tenpay Certificate";
    private static final KeyStore PKCS12_KEY_STORE;

    static {
        try {
            PKCS12_KEY_STORE = KeyStore.getInstance("PKCS12");
        } catch (KeyStoreException var1) {
            throw new PayException("Wechat pay keystore initialization failed");
        }
    }

    private FileMerchantKeyLoader() {
    }

    public static JWK rsaJwk(String storePassword, String path, String merchantId) throws PayException {

        char[] pin = storePassword.toCharArray();

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            PKCS12_KEY_STORE.load(fileInputStream, pin);
            RSAKey rsaKey = RSAKey.load(PKCS12_KEY_STORE, TENPAY_ALIAS, pin);
            return new RSAKey.Builder(rsaKey)
                    .keyID(merchantId)
                    .build();
        } catch (IOException
                 | KeyStoreException
                 | CertificateException
                 | NoSuchAlgorithmException
                 | JOSEException e) {
            throw new PayException("Fail to load tenpay certificate", e);
        }

    }
}
