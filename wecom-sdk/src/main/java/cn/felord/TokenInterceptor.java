package cn.felord;

import cn.felord.api.AccessTokenApi;
import cn.felord.api.TokenApi;
import cn.felord.domain.WeComResponse;
import cn.felord.json.JacksonObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The type Token interceptor.
 *
 * @author dax
 * @since 2023 /5/22 14:59
 */
public class TokenInterceptor implements Interceptor {
    public static final Integer INVALID_ACCESS_TOKEN = 42001;
    public static final ObjectMapper MAPPER = JacksonObjectMapperFactory.create();
    private static final List<String> WHITE_LIST = Arrays.asList("/cgi-bin/webhook/send",
            "/cgi-bin/webhook/upload_media",
            "/cgi-bin/gettoken");
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
    public Response intercept(@NotNull Chain chain) throws IOException {
        ResponseBody body;
        Response response = doRequest(chain);
        body = response.body();
        Headers headers = response.headers();
        if (body != null) {
            String json = body.string();
            WeComResponse weComResponse = MAPPER.readValue(json, WeComResponse.class);
            if (Objects.equals(INVALID_ACCESS_TOKEN, weComResponse.getErrcode())) {
                return doRequest(chain);
            }
            MediaType mediaType = body.contentType();
            return response.newBuilder()
                    .headers(headers)
                    .body(ResponseBody.create(json,mediaType))
                    .build();
        }
        return response;

    }


    private Response doRequest(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpUrl = request.url();
        String tokenResponse = tokenApi.getTokenResponse();
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
