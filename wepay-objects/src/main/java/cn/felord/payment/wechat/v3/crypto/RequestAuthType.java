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

/**
 * The enum Request auth type.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public enum RequestAuthType {
    /**
     * SHA256-RSA2048签名算法
     */
    SHA256_RSA2048("SHA256withRSA", "WECHATPAY2-SHA256-RSA2048 ");

    private final String alg;
    private final String authPrefix;

    RequestAuthType(String alg, String authPrefix) {
        this.alg = alg;
        this.authPrefix = authPrefix;
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
     * Auth prefix string.
     *
     * @param token the token
     * @return the string
     */
    public String toAuthHeader(String token) {
        return authPrefix.concat(token);
    }
}
