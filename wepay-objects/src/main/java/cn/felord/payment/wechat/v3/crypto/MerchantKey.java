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
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyType;
import lombok.Getter;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;

/**
 * 商户证书对象
 *
 * @author felord.cn
 * @since 2.0.0
 */
@Getter
public final class MerchantKey {
    /**
     * V3 Secret
     */
    private final String apiV3Secret;
    /**
     * JWK
     */
    private final JWK merchantJwk;

    /**
     * Instantiates a new Merchant key.
     *
     * @param apiV3Secret the api v3 secret
     * @param merchantJwk the merchant jwk
     */
    public MerchantKey(String apiV3Secret, JWK merchantJwk) {
        this.apiV3Secret = apiV3Secret;
        this.merchantJwk = merchantJwk;
    }

    /**
     * 获取商户号
     *
     * @return the string
     */
    public String merchantId() {
        return merchantJwk.getKeyID();
    }

    /**
     * 获取私钥
     *
     * @return the private key
     */
    public PrivateKey privateKey() {
        try {
            if (Objects.equals(KeyType.RSA, merchantJwk.getKeyType())) {
                return this.merchantJwk.toRSAKey().toPrivateKey();
            } else {
                //TODO SM2
                return this.merchantJwk.toECKey().toPrivateKey();
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    /**
     * 获取公钥
     *
     * @return the public key
     */
    public PublicKey publicKey() {
        try {
            if (Objects.equals(KeyType.RSA, merchantJwk.getKeyType())) {
                return merchantJwk.toRSAKey().toPublicKey();
            } else {
                //TODO SM3
                return merchantJwk.toECKey().toPublicKey();
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    /**
     * 证书序列号
     *
     * @return the string
     */
    public String serialNumber() {
        return merchantJwk.toPublicJWK()
                .getParsedX509CertChain()
                .get(0)
                .getSerialNumber()
                .toString(16)
                .toUpperCase();
    }

    /**
     * 获取证书类型
     *
     * @return RequestAuthType auth type
     */
    public AuthType authType() {

        if (Objects.equals(KeyType.RSA, merchantJwk.getKeyType())) {
            return AuthType.SHA256_RSA2048;
        }
        throw new PayException("Not Support Type");
    }

    /**
     * 获取api v3 secret
     *
     * @return the string
     */
    public String apiV3Secret() {
        return apiV3Secret;
    }

    @Override
    public String toString() {
        return "MerchantKey{" +
                "apiV3Secret=[PROTECTED]" +
                ", merchantJwk=" + merchantJwk +
                '}';
    }
}
