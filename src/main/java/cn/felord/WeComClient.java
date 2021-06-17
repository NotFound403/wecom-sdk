package cn.felord;

import cn.felord.domain.WeComResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

/**
 * The interface Wecom client.
 *
 * @author n1
 * @since 2021 /6/16 9:58
 */
public class WeComClient {
    private boolean needToken;
    private final RestOperations restOperations;

    /**
     * Instantiates a new We com client.
     */
    public WeComClient() {
        this.restOperations = restOperations(null);
    }

    /**
     * Instantiates a new We com client.
     *
     * @param agentDetails the agent details
     */
    public WeComClient(AgentDetails agentDetails) {
        Assert.notNull(agentDetails, "agentDetails is required");
        this.needToken = true;
        this.restOperations = restOperations(agentDetails);
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
        RequestEntity<Object> requestEntity = RequestEntity.post(uri)
                .body(body);
        return restOperations.exchange(requestEntity, responseType).getBody();
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
    public <T extends WeComResponse> T post(URI uri, Object body,  ParameterizedTypeReference<T> parameterizedTypeReference) {
        RequestEntity<Object> requestEntity = RequestEntity.post(uri)
                .body(body);
        return restOperations.exchange(requestEntity, parameterizedTypeReference).getBody();
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
        return restOperations.exchange(RequestEntity.get(uri).build(), responseType).getBody();
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
        return restOperations.exchange(RequestEntity.get(uri).build(), parameterizedTypeReference).getBody();
    }

    private RestOperations restOperations(AgentDetails agentDetails) {
        ObjectMapper objectMapper = new ObjectMapper();
        this.objectMapperCustomize(objectMapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        RestTemplate restTemplate = new RestTemplate(Collections.singletonList(mappingJackson2HttpMessageConverter));
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        if (needToken) {
            restTemplate.setInterceptors(Collections.singletonList(new AccessTokenClientHttpRequestInterceptor(agentDetails)));
        }
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
