package cn.felord;

import cn.felord.api.AbstractApi;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
public class AccessTokenClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private final AccessTokenApi accessTokenApi;


    public AccessTokenClientHttpRequestInterceptor(AgentDetails agentDetails, RestTemplate restTemplate) {
        this.accessTokenApi = new AccessTokenApi(restTemplate, agentDetails);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String path = request.getURI().getPath();
        System.out.println("path = " + path);

        MutableHttpRequest mutableHttpRequest = new MutableHttpRequest(request);

        AccessTokenResponse tokenResponse = accessTokenApi.getTokenResponse();
        if (!tokenResponse.isSuccessful()) {
            throw new RuntimeException("failed to obtain access token");
        }
        String accessToken = tokenResponse.getAccessToken();
        URI uri = UriComponentsBuilder.fromUri(request.getURI())
                .queryParam("access_token", accessToken)
                .build()
                .toUri();
        mutableHttpRequest.setUri(uri);
        return execution.execute(mutableHttpRequest, body);
    }

    private static class AccessTokenApi extends AbstractApi {
        private final AgentDetails agentDetails;

        public AccessTokenApi(RestTemplate restTemplate, AgentDetails agentDetails) {
            super(restTemplate);
            this.agentDetails = agentDetails;
        }

        AccessTokenResponse getTokenResponse() {
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                    .queryParam("corpid", agentDetails.getCorpId())
                    .queryParam("corpsecret", agentDetails.getSecret())
                    .build();
            return this.get(uriComponents.toUri(), AccessTokenResponse.class);
        }
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
