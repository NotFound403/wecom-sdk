package cn.felord.api;

import cn.felord.*;
import cn.felord.domain.WeComResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

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
        RequestEntity<Object> requestEntity = this.build(uri, body, headers);

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
        RequestEntity<Object> requestEntity = this.build(uri, body, headers);
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

    private RequestEntity<Object> build(URI uri, Object body, HttpHeaders headers) {
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
            throw new WeComException("unsuccessful response, hint: https://open.work.weixin.qq.com/devtool/query?e=" + response.getErrcode());
        }
    }

}
