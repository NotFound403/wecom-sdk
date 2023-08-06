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

/**
 * @author dax
 * @since 2023/8/6
 */
public class InMemoryMerchantConfigService implements MerchantConfigService {
    @Override
    public MerchantConfig loadConfig(String merchantId) throws PayException {

        String path = "C:\\Users\\xfa00\\IdeaProjects\\payment-spring-boot-samples\\src\\main\\resources\\wechat\\apiclient_cert.p12";
        return MerchantConfig.create("",
                path, RequestAuthType.SHA256_RSA2048);
    }
}
