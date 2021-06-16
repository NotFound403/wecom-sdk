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
    private final RestOperations restOperations = restOperations();

    /**
     * Post
     *
     * @param <T>  the type parameter
     * @param uri  the uri
     * @param body the body
     * @return the t
     */
    public <T extends WeComResponse> T post(URI uri, Object body, Class<T> responseType) {
        RequestEntity<Object> requestEntity = RequestEntity.post(uri)
                .body(body);
        return restOperations.exchange(requestEntity, responseType).getBody();
    }

    /**
     * Get
     *
     * @param <T> the type parameter
     * @param uri the uri
     * @return the t
     */
    public <T extends WeComResponse> T get(URI uri, Class<T> responseType) {
        return restOperations.exchange(RequestEntity.get(uri).build(), responseType).getBody();
    }

    private RestOperations restOperations() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.objectMapperCustomize(objectMapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        RestTemplate restTemplate = new RestTemplate(Collections.singletonList(mappingJackson2HttpMessageConverter));
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
