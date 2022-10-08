package cn.felord;

import cn.felord.api.AccessTokenApi;
import cn.felord.api.provider.ProviderTokenApi;
import cn.felord.api.TokenApi;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * Token注入拦截器
 *
 * @author felord.cn
 * @since 2021/9/11
 */
public class TokenClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private final TokenApi tokenApi;
    private final String tokenParam;


    public TokenClientHttpRequestInterceptor(TokenApi tokenApi) {
        this.tokenApi = tokenApi;
        tokenParam = this.determineTokenParam(tokenApi.getClass());
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        MutableHttpRequest mutableHttpRequest = new MutableHttpRequest(request);
        String token = tokenApi.getTokenResponse();
        URI uri = UriComponentsBuilder.fromUri(request.getURI())
                .queryParam(tokenParam, token)
                .build()
                .toUri();
        mutableHttpRequest.setUri(uri);
        return execution.execute(mutableHttpRequest, body);
    }

    /**
     * Gets token api.
     *
     * @return the token api
     */
    public TokenApi getTokenApi() {
        return tokenApi;
    }

    private String determineTokenParam(Class<? extends TokenApi> tokenApiClazz) {

        if (ProviderTokenApi.class.isAssignableFrom(tokenApiClazz)) {
            return "provider_access_token";
        }
        if (AccessTokenApi.class.isAssignableFrom(tokenApiClazz)) {
            return "access_token";
        }
        throw new WeComException("the api is not supported");
    }

    /**
     * The type Mutable http request.
     */
    static class MutableHttpRequest implements HttpRequest {

        private final HttpRequest source;
        private String methodValue;
        private URI uri;
        private HttpHeaders headers;

        /**
         * Instantiates a new Mutable http request.
         *
         * @param source the source
         */
        public MutableHttpRequest(HttpRequest source) {
            this.source = source;
            this.methodValue = source.getMethodValue();
            this.uri = source.getURI();
            this.headers = source.getHeaders();
        }

        /**
         * Sets method value.
         *
         * @param methodValue the method value
         */
        public void setMethodValue(String methodValue) {
            this.methodValue = methodValue;
        }

        /**
         * Sets uri.
         *
         * @param uri the uri
         */
        public void setUri(URI uri) {
            this.uri = uri;
        }

        /**
         * Sets headers.
         *
         * @param headers the headers
         */
        public void setHeaders(HttpHeaders headers) {
            this.headers = headers;
        }

        @Override
        public String getMethodValue() {
            return this.methodValue;
        }

        @Override
        public URI getURI() {
            return this.uri;
        }

        @Override
        public HttpHeaders getHeaders() {
            return this.headers;
        }

        /**
         * Gets source.
         *
         * @return the source
         */
        public HttpRequest getSource() {
            return source;
        }
    }

}
