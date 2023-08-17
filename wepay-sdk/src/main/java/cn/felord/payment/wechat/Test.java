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

import cn.felord.payment.wechat.v3.api.direct.DirectBasePayApi;
import cn.felord.payment.wechat.v3.api.direct.WechatPayApi;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.InMemoryAppMerchantService;
import cn.felord.payment.wechat.v3.domain.direct.basepay.BufferSource;
import cn.felord.payment.wechat.v3.domain.direct.basepay.TradeBillRequest;
import com.nimbusds.jose.JOSEException;
import okhttp3.logging.HttpLoggingInterceptor;

import java.time.LocalDate;

/**
 * @author dax
 * @since 2023/8/6
 */
public class Test {
    public static void main(String[] args) throws JOSEException {

        // 读取配置
        InMemoryAppMerchantService merchantService = new InMemoryAppMerchantService();
        AppMerchant appMerchant = merchantService.loadMerchant("wx13123123123213123123");
        // 初始化API入口
        WechatPayApi wechatPayApi = new WechatPayApi.Builder()
                .logLevel(HttpLoggingInterceptor.Level.BODY)
                .build();
        // 初始化对应API
        DirectBasePayApi directBasePayApi = wechatPayApi
                .directBasePayApi(appMerchant);

        BufferSource bufferSource = directBasePayApi.downloadTradeBill(new TradeBillRequest(LocalDate.now().minusMonths(2)));
        System.out.println("bufferSource = " + bufferSource);

/*       // 组织参数
        AppNativePayRequest payRequest = new AppNativePayRequest(
                "https://felord.cn/wx/callback",
                "felord.cn精品",
                "X12312312442343",
                new Amount(100))
                .timeExpire(OffsetDateTime.now().plusMinutes(10));
        // 调用
        AppPayResponse appPayResponse = directBasePayApi
                .app(payRequest);

        System.out.println("appPayResponse = " + appPayResponse.getPackAge());*/
    }
}
