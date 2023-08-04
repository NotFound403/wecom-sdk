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
import lombok.Data;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;

/**
 * 商户证书对象
 *
 * @author felord.cn
 * @since 2.0.0
 */
@Data
public final class MerchantKey {
    private final JWK merchantJwk;

    /**
     * 获取私钥
     *
     * @return the private key
     */
    public PrivateKey toPrivateKey() {
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

    public PublicKey toPublicKey() {
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
     * Obtain serial number string.
     *
     * @return the string
     */
    public String obtainSerialNumber() {
        return merchantJwk.toPublicJWK()
                .getParsedX509CertChain()
                .get(0)
                .getSerialNumber()
                .toString(16)
                .toUpperCase();
    }

}
