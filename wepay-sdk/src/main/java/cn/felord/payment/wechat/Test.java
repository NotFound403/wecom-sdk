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

package cn.felord.payment.wechat;

import cn.felord.payment.wechat.v3.WechatPayApi;
import cn.felord.payment.wechat.v3.crypto.*;
import com.nimbusds.jose.JOSEException;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author dax
 * @since 2023/8/6
 */
public class Test {
    public static void main(String[] args) throws JOSEException {

        InMemoryMerchantConfigService merchantConfigService = new InMemoryMerchantConfigService();
        FileMerchantKeyLoader merchantKeyLoader = new FileMerchantKeyLoader(merchantConfigService);
        WechatPaySigner wechatPaySigner = new DefaultWechatPaySigner(merchantKeyLoader);
        WechatPayApi wechatPayApi = new WechatPayApi.Builder(wechatPaySigner)
                .logLevel(HttpLoggingInterceptor.Level.BODY)
                .build();
        Merchant merchant = Merchant.create("1900006891", "", "514D90B6A480D7C289EE1F93D8A2830B", AuthType.SHA256_RSA2048);




    }
}
