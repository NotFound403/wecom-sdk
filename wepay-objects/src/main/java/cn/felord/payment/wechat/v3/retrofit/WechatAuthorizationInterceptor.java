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

package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

/**
 * The type Token interceptor.
 *
 * @author felord.cn
 * @since 2.0.0
 */
class WechatAuthorizationInterceptor extends AbstractAuthorizationInterceptor {
    private final TenpayCertificateApi tenpayCertificateApi;


    /**
     * Instantiates a new Wechat authorization interceptor.
     *
     * @param appMerchant          the app merchant
     * @param tenpayCertificateApi the tenpay certificate api
     */
    public WechatAuthorizationInterceptor(AppMerchant appMerchant, TenpayCertificateApi tenpayCertificateApi) {
        super(appMerchant);
        this.tenpayCertificateApi = tenpayCertificateApi;
    }

    @Override
    protected void consume(Response response) throws PayException {
        Headers responseHeaders = response.headers();
        String serialNumber = responseHeaders.get(HttpHeaders.WECHAT_PAY_SERIAL.headerName());
        TenpayKey tenpayKey = tenpayCertificateApi.getTenpayKey(serialNumber);
        String body = Optional.ofNullable(response.body())
                .map(b -> {
                    try {
                        return b.string();
                    } catch (IOException e) {
                        throw new PayException("Body string error", e);
                    }
                }).orElse("");
        if (!WechatPaySigner.verify(responseHeaders, body, tenpayKey)) {
            String requestId = responseHeaders.get(HttpHeaders.REQUEST_ID.headerName());
            throw new PayException("wechat pay signature verify failed, Request-ID: " + requestId);
        }
    }
}
