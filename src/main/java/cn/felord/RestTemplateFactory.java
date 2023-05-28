package cn.felord;

import cn.felord.json.JacksonObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author felord.cn
 */
public final class RestTemplateFactory {
    private RestTemplateFactory() {
    }


    public static RestTemplate restOperations() {
        ObjectMapper objectMapper = JacksonObjectMapperFactory.create();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ExtensionFormHttpMessageConverter extensionFormHttpMessageConverter = new ExtensionFormHttpMessageConverter();
        ResourceHttpMessageConverter resourceHttpMessageConverter = new ResourceHttpMessageConverter();
        RestTemplate restTemplate = new RestTemplate(Arrays.asList(extensionFormHttpMessageConverter, mappingJackson2HttpMessageConverter, resourceHttpMessageConverter));
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        DefaultResponseErrorHandler errorHandler = new WeComResponseErrorHandler();
        restTemplate.setErrorHandler(errorHandler);
        return restTemplate;
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
