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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;

/**
 * 商户基本信息
 *
 * @author dax
 * @since 2024/8/2
 */
@EqualsAndHashCode
@Getter
public class AppMerchant {
    private final String appid;
    private final String apiV3Secret;
    private final JWK merchantJwk;

    /**
     * 商户证书初始化参数
     *
     * @param appid       the appid
     * @param apiV3Secret V3 Secret
     * @param merchantJwk 商户证书JWK
     */
    @JsonCreator
    public AppMerchant(@JsonProperty("appid") String appid,
                       @JsonProperty("apiV3Secret") String apiV3Secret,
                       @JsonProperty("merchantJwk") JWK merchantJwk) {
        this.appid = appid;
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
     * 签名类型
     *
     * @return the auth type
     */
    public AuthType authType() {
        return Objects.equals(KeyType.RSA, merchantJwk.getKeyType()) ?
                AuthType.SHA256_RSA2048 : AuthType.SM2_WITH_SM3;
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

    @Override
    public String toString() {
        return "AppMerchant{" +
                "appid=" + appid +
                ", apiV3Secret=[PROTECTED]" +
                '}';
    }
}
