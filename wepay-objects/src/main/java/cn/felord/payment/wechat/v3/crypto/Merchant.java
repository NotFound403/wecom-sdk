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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 商户基本信息
 *
 * @author dax
 * @since 2023 /8/2
 */
@EqualsAndHashCode
@Getter
public class Merchant {
    private final String merchantId;
    private final String storePassword;
    private final String apiV3Secret;
    private final String sourcePath;
    private final AuthType authType;

    /**
     * 商户证书初始化参数
     *
     * @param merchantId    商户ID
     * @param storePassword 证书密码，默认是商户ID
     * @param apiV3Secret   V3 Secret
     * @param sourcePath    证书资源路径，根据实现可能是路径、URL
     * @param authType      签名类型，RSA或者国密SM
     */
    @JsonCreator
    Merchant(@JsonProperty("merchantId") String merchantId,
             @JsonProperty("storePassword") String storePassword,
             @JsonProperty("apiV3Secret") String apiV3Secret,
             @JsonProperty("sourcePath") String sourcePath,
             @JsonProperty("authType") AuthType authType) {
        this.merchantId = merchantId;
        this.storePassword = storePassword;
        this.apiV3Secret = apiV3Secret;
        this.sourcePath = sourcePath;
        this.authType = authType;
    }

    /**
     * 默认商户号就是密钥
     * <p>
     * 证书密码，默认是商户ID
     *
     * @param merchantId  商户ID
     * @param apiV3Secret V3 Secret
     * @param sourcePath  证书资源路径，根据实现可能是路径、URL
     * @param authType    签名类型，RSA或者国密SM
     * @return the merchant config
     */
    public static Merchant create(String merchantId, String apiV3Secret, String sourcePath, AuthType authType) {
        return create(merchantId, merchantId, apiV3Secret, sourcePath, authType);
    }

    /**
     * 非默认情况
     *
     * @param merchantId    商户ID
     * @param storePassword 证书密码，默认是商户ID
     * @param apiV3Secret   V3 Secret
     * @param sourcePath    证书资源路径，根据实现可能是路径、URL
     * @param authType      签名类型，RSA或者国密SM
     * @return the merchant config
     */
    public static Merchant create(String merchantId, String storePassword, String apiV3Secret, String sourcePath, AuthType authType) {
        return new Merchant(merchantId, storePassword, apiV3Secret, sourcePath, authType);
    }

    @Override
    public String toString() {
        return "MerchantConfig{" +
                "merchantId='" + merchantId + '\'' +
                ", storePassword=[PROTECTED]" +
                ", apiV3Secret=[PROTECTED]" +
                ", sourcePath=[PROTECTED]" +
                ", requestAuthType=" + authType +
                '}';
    }
}
