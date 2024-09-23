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

package cn.felord.retrofit;

import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.retrofit.json.JacksonObjectMapperFactory;
import cn.felord.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

/**
 * The type Token interceptor.
 *
 * @author dax
 * @since 2024 /5/22 14:59
 */
public class TokenInterceptor implements Interceptor {
    private static final String INVALID_ACCESS_TOKEN = "42001";
    /**
     * The constant MAPPER.
     */
    public static final ObjectMapper MAPPER = JacksonObjectMapperFactory.create();
    private static final MediaType JSON_UTF_8 = MediaType.parse("application/json; charset=UTF-8");
    private static final MediaType JSON = MediaType.parse("application/json");
    private static final String ERROR_CODE_HEADER = "error-code";
    private final TokenApi tokenApi;
    private final String tokenParam;
    private final boolean debug;

    /**
     * Instantiates a new Token interceptor.
     *
     * @param tokenApi the token api
     */
    public TokenInterceptor(TokenApi tokenApi) {
        this(tokenApi, false);
    }

    /**
     * Instantiates a new Token interceptor.
     *
     * @param tokenApi the token api
     * @param debug    the debug
     */
    public TokenInterceptor(TokenApi tokenApi, boolean debug) {
        this.tokenApi = tokenApi;
        this.tokenParam = this.determineTokenParam(tokenApi.getClass());
        this.debug = debug;
    }

    @NotNull
    @Override
    public final Response intercept(@NotNull Chain chain) throws IOException {
        Response response = doRequest(chain);
        String errorCode = response.header(ERROR_CODE_HEADER);
        // 通常不需要解析
        if (StringUtils.hasText(errorCode)) {
            if (Objects.equals(INVALID_ACCESS_TOKEN, errorCode)) {
                tokenApi.clearToken();
                response.close();
                return doRequest(chain);
            }
        } else {
            ResponseBody body = response.body();
            if (body != null) {
                //application/octet-stream
                MediaType mediaType = body.contentType();
                if (Objects.equals(JSON_UTF_8, mediaType) || Objects.equals(JSON, mediaType)) {
                    BufferedSource source = body.source();
                    source.request(Long.MAX_VALUE);
                    try (Buffer buffer = source.getBuffer().clone()) {
                        String json = buffer.readUtf8();
                        WeComResponse weComResponse = MAPPER.readValue(json, WeComResponse.class);
                        if (Objects.equals(INVALID_ACCESS_TOKEN, String.valueOf(weComResponse.getErrcode()))) {
                            tokenApi.clearToken();
                            response.close();
                            return doRequest(chain);
                        }
                    }
                }
            }
        }

        return response;
    }

    private Response doRequest(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpUrl = request.url();
        String tokenResponse = tokenApi.getToken();
        HttpUrl.Builder builder = oldHttpUrl.newBuilder()
                .addQueryParameter(tokenParam, tokenResponse);

        if (debug) {
            builder.addQueryParameter("debug", "1");
        }

        HttpUrl httpUrl = builder
                .build();

        Request requestWithAccessToken = request.newBuilder()
                .header("User-Agent", WecomUserAgent.WECOM_USER_AGENT)
                .url(httpUrl)
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
