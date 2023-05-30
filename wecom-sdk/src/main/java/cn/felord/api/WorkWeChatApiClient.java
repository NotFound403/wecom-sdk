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

package cn.felord.api;

import cn.felord.*;
import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.WeComEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;

/**
 * The type Abstract agent api.
 *
 * @author n1
 * @since 2021 /6/16 19:36
 */
@Slf4j
public final class WorkWeChatApiClient {
    private final RestTemplate restTemplate;
    private AgentDetails agentDetails;

    /**
     * Instantiates a new Abstract agent api.
     */
    WorkWeChatApiClient() {
        this.restTemplate = RestTemplateFactory.restOperations();
    }

    /**
     * Instantiates a new Work we chat api client.
     *
     * @param <T>      the type parameter
     * @param tokenApi the token api
     */
    public <T extends TokenApi> WorkWeChatApiClient(T tokenApi) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.agentDetails = tokenApi.getAgentDetails();
        TokenClientHttpRequestInterceptor interceptor = new TokenClientHttpRequestInterceptor(tokenApi);
        this.restTemplate.setInterceptors(Collections.singletonList(interceptor));
    }

    /**
     * Gets agent details.
     *
     * @return the agent details
     */
    AgentDetails getAgentDetails() {
        return agentDetails;
    }

    /**
     * Post
     *
     * @param <T>          the type parameter
     * @param endpoint     the endpoint
     * @param body         the body
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, Object body, Class<T> responseType) {
        return post(endpoint, body, null, responseType);
    }

    /**
     * Post t.
     *
     * @param <T>          the type parameter
     * @param endpoint     the endpoint
     * @param query        the query
     * @param body         the body
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, MultiValueMap<String, String> query, Object body, Class<T> responseType) {
        return post(endpoint, query, body, null, responseType);
    }

    /**
     * Post t.
     *
     * @param <T>          the type parameter
     * @param endpoint     the endpoint
     * @param body         the body
     * @param headers      the headers
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, Object body, HttpHeaders headers, Class<T> responseType) {
        RequestEntity<Object> requestEntity = this.build(endpoint, null, body, headers);
        T responseBody = restTemplate.exchange(requestEntity, responseType).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Post t.
     *
     * @param <T>          the type parameter
     * @param endpoint     the endpoint
     * @param query        the query
     * @param body         the body
     * @param headers      the headers
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, MultiValueMap<String, String> query, Object body, HttpHeaders headers, Class<T> responseType) {
        RequestEntity<Object> requestEntity = this.build(endpoint, query, body, headers);
        T responseBody = restTemplate.exchange(requestEntity, responseType).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Post t.
     *
     * @param <T>                        the type parameter
     * @param endpoint                   the endpoint
     * @param body                       the body
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, Object body, ParameterizedTypeReference<T> parameterizedTypeReference) {
        return post(endpoint, body, null, parameterizedTypeReference);
    }

    /**
     * Post t.
     *
     * @param <T>                        the type parameter
     * @param endpoint                   the endpoint
     * @param query                      the query
     * @param body                       the body
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, MultiValueMap<String, String> query, Object body, ParameterizedTypeReference<T> parameterizedTypeReference) {
        return post(endpoint, query, body, null, parameterizedTypeReference);
    }

    /**
     * Post t.
     *
     * @param <T>                        the type parameter
     * @param endpoint                   the endpoint
     * @param body                       the body
     * @param headers                    the headers
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, Object body, HttpHeaders headers, ParameterizedTypeReference<T> parameterizedTypeReference) {
        RequestEntity<Object> requestEntity = this.build(endpoint, null, body, headers);
        T responseBody = restTemplate.exchange(requestEntity, parameterizedTypeReference).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Post t.
     *
     * @param <T>                        the type parameter
     * @param endpoint                   the endpoint
     * @param query                      the query
     * @param body                       the body
     * @param headers                    the headers
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T post(WeComEndpoint endpoint, MultiValueMap<String, String> query, Object body, HttpHeaders headers, ParameterizedTypeReference<T> parameterizedTypeReference) {
        RequestEntity<Object> requestEntity = this.build(endpoint, query, body, headers);
        T responseBody = restTemplate.exchange(requestEntity, parameterizedTypeReference).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Get t.
     *
     * @param <T>          the type parameter
     * @param endpoint     the endpoint
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T get(WeComEndpoint endpoint, Class<T> responseType) {
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint.endpoint())
                .build()
                .toUri();
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), responseType).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Get t.
     *
     * @param <T>          the type parameter
     * @param endpoint     the endpoint
     * @param params       the params
     * @param responseType the response type
     * @return the t
     */
    public <T extends WeComResponse> T get(WeComEndpoint endpoint, MultiValueMap<String, String> params, Class<T> responseType) {
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint.endpoint())
                .queryParams(params)
                .build()
                .toUri();
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), responseType).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Get t.
     *
     * @param <T>                        the type parameter
     * @param endpoint                   the endpoint
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T get(WeComEndpoint endpoint, ParameterizedTypeReference<T> parameterizedTypeReference) {
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint.endpoint())
                .build()
                .toUri();
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), parameterizedTypeReference).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    /**
     * Get t.
     *
     * @param <T>                        the type parameter
     * @param endpoint                   the endpoint
     * @param params                     the params
     * @param parameterizedTypeReference the parameterized type reference
     * @return the t
     */
    public <T extends WeComResponse> T get(WeComEndpoint endpoint, MultiValueMap<String, String> params, ParameterizedTypeReference<T> parameterizedTypeReference) {
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint.endpoint())
                .queryParams(params)
                .build()
                .toUri();
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), parameterizedTypeReference).getBody();
        this.checkSuccessful(responseBody);
        return responseBody;
    }

    private RequestEntity<Object> build(WeComEndpoint endpoint, MultiValueMap<String, String> query, Object body, HttpHeaders headers) {
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint.endpoint())
                .queryParams(query)
                .build()
                .toUri();
        RequestEntity.BodyBuilder bodyBuilder = RequestEntity.post(uri);
        if (headers != null) {
            headers.forEach((key, values) -> bodyBuilder.header(key, values.toArray(new String[]{})));
        }
        return bodyBuilder.body(body);
    }

    private <T extends WeComResponse> void checkSuccessful(T response) {
        if (Objects.isNull(response)) {
            throw new WeComException("response is null");
        } else if (response.isError()) {
            if (log.isDebugEnabled()) {
                log.debug("unsuccessful response : {}", response);
            }
            if (ErrorCode.INVALID_ACCESS_TOKEN.equals(response.getErrcode())) {
                // 刷新
                this.restTemplate.getInterceptors()
                        .stream()
                        .filter(clientHttpRequestInterceptor -> clientHttpRequestInterceptor instanceof TokenClientHttpRequestInterceptor)
                        .findAny().ifPresent(clientHttpRequestInterceptor -> {
                            TokenClientHttpRequestInterceptor interceptor = (TokenClientHttpRequestInterceptor) clientHttpRequestInterceptor;
                            interceptor.getTokenApi().getTokenResponse();
                        });
                return;
            }
            throw new WeComException(response.getErrcode(), response.getErrmsg());
        }
    }

}
