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

package cn.felord.retrofit;

import cn.felord.WeComException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

/**
 * The type Token interceptor.
 *
 * @author dax
 * @since 2023 /5/22 14:59
 */
public class TokenInterceptor implements Interceptor {
    private static final String INVALID_ACCESS_TOKEN = "42001";
    private static final String ERROR_CODE_HEADER = "error-code";
    private final TokenApi tokenApi;
    private final String tokenParam;

    /**
     * Instantiates a new Token interceptor.
     *
     * @param tokenApi the token api
     */
    public TokenInterceptor(TokenApi tokenApi) {
        this.tokenApi = tokenApi;
        this.tokenParam = this.determineTokenParam(tokenApi.getClass());
    }

    @NotNull
    @Override
    public final Response intercept(@NotNull Chain chain) throws IOException {
        Response response = doRequest(chain);
        String errorCode = response.header(ERROR_CODE_HEADER);
        if (Objects.equals(INVALID_ACCESS_TOKEN, errorCode)) {
            tokenApi.clearToken();
            response.close();
            return doRequest(chain);
        }
        return response;
    }

    private Response doRequest(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpUrl = request.url();
        String tokenResponse = tokenApi.getToken();
        Request requestWithAccessToken = request.newBuilder()
                .url(oldHttpUrl.newBuilder()
                        .addQueryParameter(tokenParam, tokenResponse)
                        .build())
                .build();
        return chain.proceed(requestWithAccessToken);
    }

    private String determineTokenParam(Class<? extends TokenApi> tokenApiClazz) {

        if (AccessTokenApi.class.isAssignableFrom(tokenApiClazz)) {
            return "access_token";
        }
        throw new WeComException("the api is not supported");
    }
}
