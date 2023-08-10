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
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author dax
 * @since 2023/8/4
 */
public class FileMerchantKeyLoader implements MerchantKeyLoader {
    private static final String TENPAY_ALIAS = "Tenpay Certificate";
    private static final KeyStore PKCS12_KEY_STORE;
    private final MerchantConfigService merchantConfigService;

    public FileMerchantKeyLoader(MerchantConfigService merchantConfigService) {
        this.merchantConfigService = merchantConfigService;
    }

    static {
        try {
            PKCS12_KEY_STORE = KeyStore.getInstance("PKCS12");
        } catch (KeyStoreException var1) {
            throw new PayException(" wechat pay keystore initialization failed");
        }
    }

    @Override
    public MerchantKey loadByMerchantId(String merchantId) throws PayException {
        Merchant merchant = merchantConfigService.loadConfig(merchantId);
        char[] pin = merchant.getStorePassword().toCharArray();

        try (FileInputStream fileInputStream = new FileInputStream(merchant.getSourcePath())) {
            PKCS12_KEY_STORE.load(fileInputStream, pin);
            RSAKey rsaKey = RSAKey.load(PKCS12_KEY_STORE, TENPAY_ALIAS, pin);
            RSAKey merchantJwk = new RSAKey.Builder(rsaKey)
                    .keyID(merchant.getMerchantId())
                    .build();
            //todo cache
            return new MerchantKey(merchantJwk);
        } catch (IOException | KeyStoreException | CertificateException | NoSuchAlgorithmException | JOSEException e) {
            throw new PayException("fail to load tenpay certificate", e);
        }

    }
}
