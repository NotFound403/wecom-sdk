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

package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.util.Objects;

/**
 * The type Token interceptor.
 *
 * @author felord.cn
 * @since 2.0.0
 */
class WechatAuthorizationInterceptor extends AbstractAuthorizationInterceptor {
    private final TenpayCertificateService tenpayCertificateService;


    /**
     * Instantiates a new Wechat authorization interceptor.
     *
     * @param appMerchant              the app merchant
     * @param tenpayCertificateService the tenpay certificate api
     */
    WechatAuthorizationInterceptor(AppMerchant appMerchant, TenpayCertificateService tenpayCertificateService) {
        super(appMerchant);
        this.tenpayCertificateService = tenpayCertificateService;
    }

    @Override
    protected void verifyResponse(Response response) throws PayException {

        ResponseBody responseBody = response.body();
        String body = "";
        if (Objects.nonNull(responseBody)) {
            BufferedSource source = responseBody.source();
            try {
                source.request(Long.MAX_VALUE);
            } catch (IOException e) {
                throw new PayException("Fail Request", e);
            }
            try (Buffer buffer = source.getBuffer().clone()) {
                body = buffer.readUtf8();
            }
        }
        Headers responseHeaders = response.headers();
        if (!response.isSuccessful()) {
            String requestId = responseHeaders.get(HttpHeaders.REQUEST_ID.headerName());
            String errorMessage = " Code: " + response.code() +
                    "\n Request-ID: " + requestId +
                    "\n Message: " + response.message() +
                    "\n Body: " + body;
            response.close();
            throw new PayException(errorMessage);
        }
        String serialNumber = responseHeaders.get(HttpHeaders.WECHAT_PAY_SERIAL.headerName());
        TenpayKey tenpayKey = tenpayCertificateService.getTenpayKey(serialNumber);
        if (!WechatPaySigner.verify(responseHeaders, body, tenpayKey)) {
            String requestId = responseHeaders.get(HttpHeaders.REQUEST_ID.headerName());
            response.close();
            throw new PayException("Wechat pay signature verify failed, Request-ID: " + requestId);
        }
    }
}
