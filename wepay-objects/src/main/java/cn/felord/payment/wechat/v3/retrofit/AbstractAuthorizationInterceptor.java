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
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import cn.felord.utils.OkHttpUtil;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static cn.felord.payment.wechat.v3.WepaySdkVersion.USER_AGENT;

/**
 * The type Abstract authorization interceptor.
 *
 * @author dax
 * @since 2024/8/16 9:36
 */
public abstract class AbstractAuthorizationInterceptor implements Interceptor {
    private static final String APPLICATION_JSON_UTF_8 = "application/json; charset=UTF-8";
    private static final String DOWNLOAD_FILE_PATH = "/v3/billdownload/file";
    private final AppMerchant appMerchant;

    /**
     * Instantiates a new Abstract authorization interceptor.
     *
     * @param appMerchant the app merchant
     */
    public AbstractAuthorizationInterceptor(AppMerchant appMerchant) {
        this.appMerchant = appMerchant;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers headers = request.headers();
        String mediaBody = headers.get(HttpHeaders.META.headerName());
        String bodyStr = Optional.ofNullable(mediaBody)
                .orElseGet(() ->
                        Optional.ofNullable(request.body())
                                .map(OkHttpUtil::requestBodyToString)
                                .orElse(""));
        HttpUrl httpUrl = request.url();
        String authorization = WechatPaySigner.sign(appMerchant, httpUrl.uri(), request.method(), bodyStr);
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
        Response response = chain.proceed(requestWithAuth);
        if (!Objects.equals(DOWNLOAD_FILE_PATH, httpUrl.encodedPath())) {
            this.verifyResponse(response);
        }
        return response;
    }

    /**
     * Consume.
     *
     * @param response the response
     * @throws PayException the pay exception
     */
    protected abstract void verifyResponse(Response response) throws PayException;

}
