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

import java.util.Arrays;
import java.util.Objects;

/**
 * 签名类型
 *
 * @author felord.cn
 * @since 2.0.0
 */
public enum AuthType {

    /**
     * SHA256-RSA2048签名算法
     */
    SHA256_RSA2048("SHA256withRSA", "WECHATPAY2-SHA256-RSA2048", "RSA/ECB/OAEPWithSHA-1AndMGF1Padding"),
    /**
     * 国密SM签名算法
     */
    SM2_WITH_SM3("SM2", "WECHATPAY2-SM2-WITH-SM3", "SM2");

    private final String alg;
    private final String signType;
    private final String transformation;

    AuthType(String alg, String signType, String transformation) {
        this.alg = alg;
        this.signType = signType;
        this.transformation = transformation;
    }

    /**
     * Gets alg.
     *
     * @return the alg
     */
    public String alg() {
        return alg;
    }

    /**
     * Transformation string.
     *
     * @return the string
     */
    public String transformation() {
        return transformation;
    }

    /**
     * From sign type request auth type.
     *
     * @param signType the sign type
     * @return the request auth type
     */
    public static AuthType fromSignType(String signType) {
        return Arrays.stream(AuthType.values())
                .filter(requestAuthType ->
                        Objects.equals(requestAuthType.signType, signType))
                .findAny()
                .orElseThrow(() -> new PayException("This signType is not supported"));
    }

    /**
     * Auth prefix string.
     *
     * @param token the token
     * @return the string
     */
    public String toAuthHeader(String token) {
        return signType.concat(" ").concat(token);
    }
}
