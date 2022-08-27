package cn.felord.api;

import cn.felord.AccessTokenClientHttpRequestInterceptor;
import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;
import cn.felord.ErrorCode;
import cn.felord.RestTemplateFactory;
import cn.felord.WeComException;
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
 * @author n1
 * @since 2021/6/16 17:36
 */
@Slf4j
public abstract class AbstractApi {
    private final RestTemplate restTemplate;
    private final AccessTokenClientHttpRequestInterceptor requestInterceptor;

    /**
     * Instantiates a new We com client.
     */
    public AbstractApi(TokenCacheable tokenCacheable) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.requestInterceptor = new AccessTokenClientHttpRequestInterceptor(new AccessTokenApi(tokenCacheable));
    }

    /**
     * With agent.
     *
     * @param agentDetails the agent details
     */
    protected <A extends AgentDetails> void withAgent(A agentDetails) {
        requestInterceptor.setAgentDetails(agentDetails);
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
    protected <T extends WeComResponse> T post(URI uri, Object body, Class<T> responseType) {
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
    protected <T extends WeComResponse> T post(URI uri, Object body, HttpHeaders headers, Class<T> responseType) {
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
    protected <T extends WeComResponse> T post(URI uri, Object body, ParameterizedTypeReference<T> parameterizedTypeReference) {
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
    protected <T extends WeComResponse> T post(URI uri, Object body, HttpHeaders headers, ParameterizedTypeReference<T> parameterizedTypeReference) {
        RequestEntity<Object> requestEntity = this.build(uri, body, headers);
        T responseBody = restTemplate.exchange(requestEntity, parameterizedTypeReference).getBody();
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


    /**
     * Get
     *
     * @param <T>          the type parameter
     * @param uri          the uri
     * @param responseType the response type
     * @return the t
     */
    protected <T extends WeComResponse> T get(URI uri, Class<T> responseType) {
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
    protected <T extends WeComResponse> T get(URI uri, ParameterizedTypeReference<T> parameterizedTypeReference) {
        T responseBody = restTemplate.exchange(RequestEntity.get(uri).build(), parameterizedTypeReference).getBody();
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
            if (ErrorCode.INVALID_ACCESS_TOKEN.equals(response.getErrcode())) {
                // 刷新
                this.restTemplate.getInterceptors()
                        .stream()
                        .filter(clientHttpRequestInterceptor -> clientHttpRequestInterceptor instanceof AccessTokenClientHttpRequestInterceptor)
                        .findAny().ifPresent(clientHttpRequestInterceptor -> {
                            AccessTokenClientHttpRequestInterceptor interceptor = (AccessTokenClientHttpRequestInterceptor) clientHttpRequestInterceptor;
                            interceptor.getAccessTokenApi().getTokenResponse(interceptor.getAgentDetails());
                        });
                return;
            }
            throw new WeComException("unsuccessful response, hint: https://open.work.weixin.qq.com/devtool/query?e=" + response.getErrcode());
        }
    }

}
