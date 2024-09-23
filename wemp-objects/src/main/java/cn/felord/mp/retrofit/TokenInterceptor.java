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

package cn.felord.mp.retrofit;

import cn.felord.retrofit.json.JacksonObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The type Token interceptor.
 *
 * @author dax
 * @since 2024/5/22 14:59
 */
public class TokenInterceptor implements Interceptor {
    public static final ObjectMapper MAPPER = JacksonObjectMapperFactory.create();
    private static final MediaType JSON_UTF_8 = MediaType.parse("application/json; charset=UTF-8");
    private static final MediaType JSON = MediaType.parse("application/json");
    private final TokenApi tokenApi;


    /**
     * Instantiates a new Token interceptor.
     *
     * @param tokenApi the token api
     */
    public TokenInterceptor(TokenApi tokenApi) {
        this.tokenApi = tokenApi;
    }

    @NotNull
    @Override
    public final Response intercept(@NotNull Chain chain) throws IOException {
        return doRequest(chain);
    }


    private Response doRequest(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpUrl = request.url();
        String tokenResponse = tokenApi.getToken();
        Request requestWithAccessToken = request.newBuilder()
                .url(oldHttpUrl.newBuilder()
                        .addQueryParameter("access_token", tokenResponse)
                        .build())
                .build();
        return chain.proceed(requestWithAccessToken);
    }

}
