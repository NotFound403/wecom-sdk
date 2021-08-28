package cn.felord.http;

import cn.felord.AccessTokenClientHttpRequestInterceptor;
import cn.felord.AgentDetails;
import cn.felord.ExtensionFormHttpMessageConverter;
import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author n1
 * @since 2021/8/28 16:54
 */
@Slf4j
public class WeComRestTemplate extends RestTemplate {

    public WeComRestTemplate() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.objectMapperCustomize(objectMapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ExtensionFormHttpMessageConverter extensionFormHttpMessageConverter = new ExtensionFormHttpMessageConverter();
        this.setMessageConverters(Arrays.asList(extensionFormHttpMessageConverter, mappingJackson2HttpMessageConverter));
        this.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        DefaultResponseErrorHandler errorHandler = new WeComResponseErrorHandler();
        this.setErrorHandler(errorHandler);
    }

    public <A extends AgentDetails> Exchange withAgent(A agentDetails) {
        AccessTokenClientHttpRequestInterceptor requestInterceptor = new AccessTokenClientHttpRequestInterceptor(agentDetails, this);
        this.setInterceptors(Collections.singletonList(requestInterceptor));
        return new Exchange(this);
    }

    public <A extends AgentDetails> Exchange withAgent(Supplier<A> supplier) {
        AccessTokenClientHttpRequestInterceptor requestInterceptor = new AccessTokenClientHttpRequestInterceptor(supplier.get(), this);
        this.setInterceptors(Collections.singletonList(requestInterceptor));
        return new Exchange(this);
    }

    public static class Exchange {
        private final WeComRestTemplate weComRestTemplate;

        public Exchange(WeComRestTemplate weComRestTemplate) {
            this.weComRestTemplate = weComRestTemplate;
        }

        public <T extends WeComResponse> T post(WeComEndpoint weComEndpoint, Object body, Class<T> responseType) {
            return post(weComEndpoint, body, null, responseType);
        }

        public <T extends WeComResponse> T post(WeComEndpoint weComEndpoint, Object body, HttpHeaders headers, Class<T> responseType) {
            String endpoint = weComEndpoint.endpoint(WeComDomain.CGI_BIN);
            RequestEntity<Object> requestEntity = RequestEntity.post(endpoint).headers(headers)
                    .body(body);
            T responseBody = weComRestTemplate.exchange(requestEntity, responseType).getBody();
            this.checkSuccessful(responseBody);
            return responseBody;
        }

        public <T extends WeComResponse> T post(WeComEndpoint weComEndpoint, Object body, ParameterizedTypeReference<T> parameterizedTypeReference) {
            return post(weComEndpoint, body, null, parameterizedTypeReference);
        }

        public <T extends WeComResponse> T post(WeComEndpoint weComEndpoint, Object body, HttpHeaders headers, ParameterizedTypeReference<T> parameterizedTypeReference) {
            String endpoint = weComEndpoint.endpoint(WeComDomain.CGI_BIN);
            RequestEntity<Object> requestEntity = RequestEntity.post(endpoint).headers(headers)
                    .body(body);
            T responseBody = weComRestTemplate.exchange(requestEntity, parameterizedTypeReference).getBody();
            this.checkSuccessful(responseBody);
            return responseBody;
        }

        public <T extends WeComResponse> T get(URI uri, Class<T> responseType) {
            T responseBody = weComRestTemplate.exchange(RequestEntity.get(uri).build(), responseType).getBody();
            this.checkSuccessful(responseBody);
            return responseBody;
        }

        public <T extends WeComResponse> T get(URI uri, ParameterizedTypeReference<T> parameterizedTypeReference) {
            T responseBody = weComRestTemplate.exchange(RequestEntity.get(uri).build(), parameterizedTypeReference).getBody();
            this.checkSuccessful(responseBody);
            return responseBody;
        }

        private <T extends WeComResponse> void checkSuccessful(T response) {
            if (Objects.isNull(response)) {
                throw new WeComException("response is null");
            } else if (!response.isSuccessful()) {
                if (log.isDebugEnabled()) {
                    log.debug("unsuccessful response : {}", response);
                }
                throw new WeComException("unsuccessful response");
            }
        }
    }


    private void objectMapperCustomize(ObjectMapper mapper) {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                // empty string error
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule());
    }

    public static class WeComResponseErrorHandler extends DefaultResponseErrorHandler {
        @Override
        public boolean hasError(ClientHttpResponse response) {
            return false;
        }
    }
}
