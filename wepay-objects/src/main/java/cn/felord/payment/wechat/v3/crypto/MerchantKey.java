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
    private final String merchantId;
    private final String serialNumber;
    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final JWK merchantJwk;

    public MerchantKey(JWK merchantJwk) {
        this.merchantId = merchantJwk.getKeyID();
        this.serialNumber = this.obtainSerialNumber(merchantJwk);
        this.privateKey = this.toPrivateKey(merchantJwk);
        this.publicKey = this.toPublicKey(merchantJwk);
        this.merchantJwk = merchantJwk;
    }

    /**
     * 获取私钥
     *
     * @return the private key
     */
    private PrivateKey toPrivateKey(JWK merchantJwk) {
        try {
            if (Objects.equals(KeyType.RSA, merchantJwk.getKeyType())) {
                return merchantJwk.toRSAKey().toPrivateKey();
            } else {
                //TODO SM3
                return merchantJwk.toECKey().toPrivateKey();
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    /**
     * To public key public key.
     *
     * @return the public key
     */
    private PublicKey toPublicKey(JWK merchantJwk) {
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
    private String obtainSerialNumber(JWK merchantJwk) {
        return merchantJwk.toPublicJWK()
                .getParsedX509CertChain()
                .get(0)
                .getSerialNumber()
                .toString(16)
                .toUpperCase();
    }

    @Override
    public String toString() {
        return "MerchantKey{" +
                "merchantId='" + merchantId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", privateKey=[PROTECTED]" +
                ", publicKey=[PROTECTED]" +
                ", merchantJwk=[PROTECTED]" +
                '}';
    }
}
