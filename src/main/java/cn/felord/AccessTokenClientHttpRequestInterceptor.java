package cn.felord;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
public class AccessTokenClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        MutableHttpRequest mutableHttpRequest = new MutableHttpRequest(request);

        URI uri = UriComponentsBuilder.fromUri(request.getURI())
                .queryParam("access_token", "0V0POBxjCwYQYXc-aWf_Q8SlhUaOKeNmva7PqKc-SGahAqqJiQaB9IKS67_FRkgpcC4yVGJxlAo73z6SwwQJDWMXtGQ--RwPTlQTVoY_syH2SLoQDey2bTeVTzaqfK2FKadDDIBbfUFvXEl6-PSEpoJhu8H2cDmAMeSn2SvNP-2S9TSBJIDrak7XFrSBAflXAIBX5q_4yt9cMXSkddSKaA")
                .build()
                .toUri();
        mutableHttpRequest.setUri(uri);
        return execution.execute(mutableHttpRequest, body);
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
