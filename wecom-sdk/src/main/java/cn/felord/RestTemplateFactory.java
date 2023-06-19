/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord;

import cn.felord.api.TokenApi;
import cn.felord.json.JacksonObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * The type Rest template factory.
 *
 * @author felord.cn
 */
public final class RestTemplateFactory {
    private RestTemplateFactory() {
    }

    /**
     * Rest operations rest template.
     *
     * @return the rest template
     */
    public static RestTemplate restOperations() {
        ObjectMapper objectMapper = JacksonObjectMapperFactory.create();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ExtensionFormHttpMessageConverter extensionFormHttpMessageConverter = new ExtensionFormHttpMessageConverter();
        ResourceHttpMessageConverter resourceHttpMessageConverter = new ResourceHttpMessageConverter();
        RestTemplate restTemplate = new RestTemplate(Arrays.asList(extensionFormHttpMessageConverter, mappingJackson2HttpMessageConverter, resourceHttpMessageConverter));
        DefaultResponseErrorHandler errorHandler = new WeComResponseErrorHandler();
        restTemplate.setErrorHandler(errorHandler);
        restTemplate.setRequestFactory(clientHttpRequestFactory());
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

    /**
     * Client http request factory ok http 3 client http request factory.
     *
     * @param tokenApi the token api
     * @param level    the level
     * @return the ok http 3 client http request factory
     */
    public static OkHttp3ClientHttpRequestFactory clientHttpRequestFactory(TokenApi tokenApi, HttpLoggingInterceptor.Level level) {
        ConnectionPool connectionPool = new ConnectionPool(20, 5L, TimeUnit.MINUTES);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(level);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor(tokenApi))
                .addInterceptor(httpLoggingInterceptor)
                //.sslSocketFactory(sslSocketFactory(), x509TrustManager())
                .retryOnConnectionFailure(true)
                .connectionPool(connectionPool)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }

    /**
     * Client http request factory ok http 3 client http request factory.
     *
     * @return the ok http 3 client http request factory
     */
    public static OkHttp3ClientHttpRequestFactory clientHttpRequestFactory() {
        ConnectionPool connectionPool = new ConnectionPool(20, 5L, TimeUnit.MINUTES);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.sslSocketFactory(sslSocketFactory(), x509TrustManager())
                .retryOnConnectionFailure(true)
                .connectionPool(connectionPool)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }
}
