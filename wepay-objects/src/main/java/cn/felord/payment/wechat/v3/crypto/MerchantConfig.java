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

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The type MerchantConfig.
 *
 * @author dax
 * @since 2023 /8/2
 */
@EqualsAndHashCode
@Getter
public class MerchantConfig {
    private final String merchantId;
    private final String storePassword;
    private final String appV3Secret;
    private final String sourcePath;
    private final RequestAuthType requestAuthType;

    /**
     * 商户证书初始化参数
     *
     * @param merchantId      商户ID
     * @param storePassword   证书密码，默认是商户ID
     * @param appV3Secret     V3 Secret
     * @param sourcePath      证书资源路径，根据实现可能是路径、URL
     * @param requestAuthType 签名类型，RSA或者国密SM
     */
    MerchantConfig(String merchantId, String storePassword, String appV3Secret, String sourcePath, RequestAuthType requestAuthType) {
        this.merchantId = merchantId;
        this.storePassword = storePassword;
        this.appV3Secret = appV3Secret;
        this.sourcePath = sourcePath;
        this.requestAuthType = requestAuthType;
    }

    /**
     * 默认商户号就是密钥
     *
     * @param merchantId      the merchant id
     * @param sourcePath      the source path
     * @param appV3Secret     the app v 3 secret
     * @param requestAuthType the request auth type
     * @return the merchant config
     */
    public static MerchantConfig create(String merchantId, String sourcePath, String appV3Secret, RequestAuthType requestAuthType) {
        return create(merchantId, merchantId, appV3Secret, sourcePath, requestAuthType);
    }

    /**
     * 非默认情况
     *
     * @param merchantId      the merchant id
     * @param storePassword   the storePassword
     * @param appV3Secret     the app v 3 secret
     * @param sourcePath      the source path
     * @param requestAuthType the request auth type
     * @return the merchant config
     */
    public static MerchantConfig create(String merchantId, String storePassword, String appV3Secret, String sourcePath, RequestAuthType requestAuthType) {
        return new MerchantConfig(merchantId, storePassword, appV3Secret, sourcePath, requestAuthType);
    }

    @Override
    public String toString() {
        return "MerchantConfig{" +
                "merchantId='" + merchantId + '\'' +
                ", storePassword=[PROTECTED]" +
                ", appV3Secret=[PROTECTED]" +
                ", sourcePath=[PROTECTED]" +
                ", requestAuthType=" + requestAuthType +
                '}';
    }
}
