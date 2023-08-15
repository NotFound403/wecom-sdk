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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyType;
import lombok.Getter;

import java.security.PublicKey;
import java.util.Objects;

/**
 * 微信平台证书
 *
 * @author dax
 * @since 2023 /8/10 13:54
 */
@Getter
public class TenpayKey {
    private final String merchantId;
    private final String serialNumber;
    private final JWK tenPayJwk;

    /**
     * Instantiates a new Tenpay public key.
     *
     * @param merchantId   the merchant id
     * @param serialNumber the serial number
     * @param tenPayJwk    the tenPay jwk
     */
    @JsonCreator
    public TenpayKey(@JsonProperty("merchantId") String merchantId,
                     @JsonProperty("serialNumber") String serialNumber,
                     @JsonProperty("tenPayJwk") JWK tenPayJwk) {
        this.merchantId = merchantId;
        this.serialNumber = serialNumber;
        this.tenPayJwk = tenPayJwk;
    }

    /**
     * To public key
     *
     * @return the public key
     */
    public PublicKey toPublicKey() {
        try {
            if (Objects.equals(KeyType.RSA, tenPayJwk.getKeyType())) {
                return tenPayJwk.toRSAKey().toPublicKey();
            } else {
                throw new PayException("Not Support KeyType");
            }
        } catch (JOSEException e) {
            throw new PayException("Fail to load key", e);
        }
    }

    @Override
    public String toString() {
        return "TenpayKey{" +
                "merchantId=" + merchantId +
                ", serialNumber=" + serialNumber +
                ", tenPayJwk=[PROTECTED]" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TenpayKey tenpayKey = (TenpayKey) o;

        if (!Objects.equals(merchantId, tenpayKey.merchantId)) return false;
        return Objects.equals(serialNumber, tenpayKey.serialNumber);
    }

    @Override
    public int hashCode() {
        int result = merchantId != null ? merchantId.hashCode() : 0;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        return result;
    }
}
