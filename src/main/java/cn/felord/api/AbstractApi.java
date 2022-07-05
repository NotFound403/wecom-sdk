package cn.felord.api;

import cn.felord.AccessTokenClientHttpRequestInterceptor;
import cn.felord.AgentDetails;
import cn.felord.ExtensionFormHttpMessageConverter;
import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
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

/**
 * @author n1
 * @since 2021/6/16 17:36
 */
@Slf4j
public abstract class AbstractApi {
    private final RestTemplate restTemplate;

    /**
     * Instantiates a new We com client.
     */
    public AbstractApi() {
        this.restTemplate = this.restOperations();
    }

    public AbstractApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * With agent.
     *
     * @param agentDetails the agent details
     */
    public <A extends AgentDetails> void withAgent(A agentDetails) {
        AccessTokenClientHttpRequestInterceptor requestInterceptor = new AccessTokenClientHttpRequestInterceptor(agentDetails, this.restOperations());
        this.restTemplate.setInterceptors(Collections.singletonList(requestInterceptor));
    }

    /**
     * Post
     *
     * @param <T>          the type parameter
     * @param uri          the uri
     * @param body         the body
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T post(URI uri, Object body, Class<T> responseType) {
        return post(uri, body, null, responseType);
    }

    /**
     * Post t.
     *
     * @param <T>          the type parameter
     * @param uri          the uri
     * @param body         the body
     * @param headers      the headers
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T post(URI uri, Object body, HttpHeaders headers, Class<T> responseType) {
        RequestEntity<Object> requestEntity = RequestEntity.post(uri).headers(headers)
                .body(body);
        T responseBody = restTemplate.exchange(requestEntity, responseType).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Post t.
     *
     * @param <T>                        the type parameter
     * @param uri                        the uri
     * @param body                       the body
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T post(URI uri, Object body, ParameterizedTypeReference<T> parameterizedTypeReference) {
        return post(uri, body, null, parameterizedTypeReference);
    }

    /**
     * Post t.
     *
     * @param <T>                        the type parameter
     * @param uri                        the uri
     * @param body                       the body
     * @param headers                    the headers
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T post(URI uri, Object body, HttpHeaders headers, ParameterizedTypeReference<T> parameterizedTypeReference) {
        RequestEntity<Object> requestEntity = RequestEntity.post(uri).headers(headers)
                .body(body);
        T responseBody = restTemplate.exchange(requestEntity, parameterizedTypeReference).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Get
     *
     * @param <T>          the type parameter
     * @param uri          the uri
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T get(URI uri, Class<T> responseType) {
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), responseType).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Get t.
     *
     * @param <T>                        the type parameter
     * @param uri                        the uri
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T get(URI uri, ParameterizedTypeReference<T> parameterizedTypeReference) {
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), parameterizedTypeReference).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    private <T extends WeComResponse> void checkSuccessful(T response) {
        if (Objects.isNull(response)) {
          throw new WeComException("response is null");
        } else if (!response.isSuccessful()) {
             if (log.isDebugEnabled()){
                 log.debug("unsuccessful response : {}",response);
             }
             throw new WeComException("unsuccessful response");
        }
    }

    private RestTemplate restOperations() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.objectMapperCustomize(objectMapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ExtensionFormHttpMessageConverter extensionFormHttpMessageConverter = new ExtensionFormHttpMessageConverter();
        RestTemplate restTemplate = new RestTemplate(Arrays.asList(extensionFormHttpMessageConverter, mappingJackson2HttpMessageConverter));
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        DefaultResponseErrorHandler errorHandler = new WeComResponseErrorHandler();
        restTemplate.setErrorHandler(errorHandler);
        return restTemplate;
    }


    private void objectMapperCustomize(ObjectMapper mapper) {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                // empty string error
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule());
    }

    /**
     * The type We com response error handler.
     */
    public static class WeComResponseErrorHandler extends DefaultResponseErrorHandler {
        @Override
        public boolean hasError(ClientHttpResponse response) {
            return false;
        }
    }
}
