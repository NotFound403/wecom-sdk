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
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import cn.felord.utils.OkHttpUtil;
import cn.felord.utils.StringUtils;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static cn.felord.payment.wechat.v3.retrofit.WepaySdkVersion.USER_AGENT;

/**
 * The type Token interceptor.
 *
 * @author felord.cn
 * @since 2.0.0
 */
class WechatAuthorizationInterceptor implements Interceptor {
    private static final String APPLICATION_JSON_UTF_8 = "application/json; charset=UTF-8";
    private final String merchantId;
    private final WechatPaySigner wechatPaySigner;


    /**
     * Instantiates a new Wechat authorization interceptor.
     *
     * @param merchantId      the merchant id
     * @param wechatPaySigner the wechat pay signer
     */
    WechatAuthorizationInterceptor(String merchantId, WechatPaySigner wechatPaySigner) {
        if (StringUtils.hasNoText(merchantId)) {
            throw new PayException("merchantId is required");
        }
        this.merchantId = merchantId;
        this.wechatPaySigner = wechatPaySigner;
    }

    @NotNull
    @Override
    public final Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers headers = request.headers();
        String mediaBody = headers.get(HttpHeaders.META.headerName());
        String bodyStr = Objects.nonNull(mediaBody) ? mediaBody :
                Optional.ofNullable(request.body())
                        .map(OkHttpUtil::requestBodyToString)
                        .orElse("");
        HttpUrl httpUrl = request.url();
        String authorization = wechatPaySigner.sign(merchantId, httpUrl.uri(), request.method(), bodyStr);

        Headers.Builder headerBuilder = headers.newBuilder();
        String contentType = HttpHeaders.CONTENT_TYPE.headerName();
        if (Objects.isNull(headers.get(contentType))) {
            headerBuilder.set(contentType, APPLICATION_JSON_UTF_8);
        }
        Request requestWithAuth = request.newBuilder()
                .url(httpUrl)
                .header(HttpHeaders.AUTHORIZATION.headerName(), authorization)
                .header(HttpHeaders.USER_AGENT.headerName(), USER_AGENT)
                .header(HttpHeaders.ACCEPT.headerName(), "*/*")
                .build();
        return chain.proceed(requestWithAuth);
    }

}
