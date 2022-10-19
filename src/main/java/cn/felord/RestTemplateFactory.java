package cn.felord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Arrays;

/**
 * @author felord.cn
 */
public final class RestTemplateFactory {
    private RestTemplateFactory() {
    }


    public static RestTemplate restOperations() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapperCustomize(objectMapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ExtensionFormHttpMessageConverter extensionFormHttpMessageConverter = new ExtensionFormHttpMessageConverter();
        RestTemplate restTemplate = new RestTemplate(Arrays.asList(extensionFormHttpMessageConverter, mappingJackson2HttpMessageConverter));
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        DefaultResponseErrorHandler errorHandler = new WeComResponseErrorHandler();
        restTemplate.setErrorHandler(errorHandler);
        return restTemplate;
    }


    private static void objectMapperCustomize(ObjectMapper mapper) {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(Instant.class, UnixInstantSerializer.INSTANCE);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                // empty string error
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(javaTimeModule);
    }

    /**
     * The type Wecom response error handler.
     */
    public static class WeComResponseErrorHandler extends DefaultResponseErrorHandler {
        @Override
        public boolean hasError(ClientHttpResponse response) {
            return false;
        }
    }
}
