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

import cn.felord.payment.wechat.v3.CertificateApi;
import cn.felord.payment.wechat.v3.WechatPayApi;
import cn.felord.payment.wechat.v3.crypto.DefaultRequestAuthenticator;
import cn.felord.payment.wechat.v3.crypto.FileMerchantKeyLoader;
import cn.felord.payment.wechat.v3.crypto.InMemoryMerchantConfigService;
import cn.felord.payment.wechat.v3.domain.WechatPayResponse;
import cn.felord.payment.wechat.v3.domain.certificate.TenpayCertificate;
import okhttp3.logging.HttpLoggingInterceptor;

import java.util.List;

/**
 * @author dax
 * @since 2023/8/6
 */
public class Test {
    public static void main(String[] args) {

        WechatPayApi wechatPayApi = new WechatPayApi.Builder(new DefaultRequestAuthenticator(new FileMerchantKeyLoader(new InMemoryMerchantConfigService())))
                .logLevel(HttpLoggingInterceptor.Level.BODY)
                .build();

        CertificateApi certificateApi = wechatPayApi.certificateApi("1900006891");

        WechatPayResponse<List<TenpayCertificate>> certificates = certificateApi.certificates();
// 信息: {"code":"INVALID_REQUEST","message":"Http头缺少Accept或User-Agent"}
        System.out.println("certificates = " + certificates);


    }
}
