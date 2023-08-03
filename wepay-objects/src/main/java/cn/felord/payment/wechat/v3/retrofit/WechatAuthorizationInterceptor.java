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

import cn.felord.payment.wechat.v3.crypto.MerchantConfig;
import cn.felord.payment.wechat.v3.crypto.RequestAuthenticator;
import cn.felord.utils.OkHttpUtil;
import lombok.Getter;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Token interceptor.
 *
 * @author felord.cn
 * @since 2.0.0
 */
class WechatAuthorizationInterceptor implements Interceptor {
    private static final String APPLICATION_JSON_UTF_8 = "application/json; charset=UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    private final RequestAuthenticator requestAuthenticator;
    @Getter
    private final MerchantConfig merchantConfig;


    public WechatAuthorizationInterceptor(RequestAuthenticator requestAuthenticator, MerchantConfig merchantConfig) {
        this.requestAuthenticator = requestAuthenticator;
        this.merchantConfig = merchantConfig;
    }

    @NotNull
    @Override
    public final Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers headers = request.headers();
        String mediaBody = headers.get("Meta-Info");
        String bodyStr = Objects.nonNull(mediaBody) ? mediaBody :
                Optional.ofNullable(request.body())
                        .map(OkHttpUtil::requestBodyToString)
                        .orElse("");

        HttpUrl httpUrl = request.url();
        String authorization = requestAuthenticator.authHeader(merchantConfig, httpUrl.uri(), request.method(), bodyStr);

        Headers.Builder headerBuilder = headers.newBuilder();
        headerBuilder.removeAll("Meta-Info");
        if (Objects.isNull(headers.get("Content-Type"))) {
            headerBuilder.set("Content-Type", APPLICATION_JSON_UTF_8);
        }
        Request requestWithAuth = request.newBuilder()
                .url(httpUrl)
                .header("Authorization", authorization)
                .header("User-Agent", "Wepay")
                .header("Accept", APPLICATION_JSON)
                .headers(headerBuilder.build())
                .build();
        return chain.proceed(requestWithAuth);
    }

}
