package cn.felord;

import cn.felord.api.AccessTokenApi;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author dax
 * @since 1.0.8.RELEASE
 */
public class AccessTokenClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private final AccessTokenApi accessTokenApi;
    private  AgentDetails agentDetails;

    public AccessTokenClientHttpRequestInterceptor(AccessTokenApi accessTokenApi) {
        this.accessTokenApi = accessTokenApi;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        MutableHttpRequest mutableHttpRequest = new MutableHttpRequest(request);
        String accessToken = accessTokenApi.getTokenResponse(agentDetails);

        URI uri = UriComponentsBuilder.fromUri(request.getURI())
                .queryParam("access_token", accessToken)
                .build()
                .toUri();
        mutableHttpRequest.setUri(uri);
        return execution.execute(mutableHttpRequest, body);
    }

    public void setAgentDetails(AgentDetails agentDetails) {
        this.agentDetails = agentDetails;
    }

    public AgentDetails getAgentDetails() {
        return agentDetails;
    }

    public AccessTokenApi getAccessTokenApi() {
        return accessTokenApi;
    }

    static class MutableHttpRequest implements HttpRequest {

        private final HttpRequest source;
        private String methodValue;
        private URI uri;
        private HttpHeaders headers;

        public MutableHttpRequest(HttpRequest source) {
            this.source = source;
            this.methodValue = source.getMethodValue();
            this.uri = source.getURI();
            this.headers = source.getHeaders();
        }

        public void setMethodValue(String methodValue) {
            this.methodValue = methodValue;
        }

        public void setUri(URI uri) {
            this.uri = uri;
        }

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

        public HttpRequest getSource() {
            return source;
        }
    }

}
