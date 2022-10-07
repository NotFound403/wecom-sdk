package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.RestTemplateFactory;
import cn.felord.WeComCacheable;
import cn.felord.WeComException;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * The type Access token api.
 *
 * @author felord.cn
 */
public class AccessTokenApi {
    private final RestTemplate restTemplate;
    private final WeComCacheable wecomCacheable;


    /**
     * Instantiates a new Access token api.
     *
     * @param wecomCacheable the wecom cacheable
     */
    AccessTokenApi(WeComCacheable wecomCacheable) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.wecomCacheable = wecomCacheable;
    }


    /**
     * Gets token response.
     *
     * @param agentDetails the agent details
     * @return the token response
     */
    public String getTokenResponse(AgentDetails agentDetails) {
        String corpId = agentDetails.getCorpId();
        String agentId = agentDetails.getAgentId();
        String tokenCache = wecomCacheable.getToken(corpId, agentId);
        if (tokenCache == null) {
            synchronized (this) {
                tokenCache = wecomCacheable.getToken(corpId, agentId);
                if (tokenCache==null){
                    UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                            .queryParam("corpid", corpId)
                            .queryParam("corpsecret", agentDetails.getSecret())
                            .build();
                    AccessTokenResponse tokenResponse = this.restTemplate.getForObject(uriComponents.toUri(), AccessTokenResponse.class);
                    if (tokenResponse == null || tokenResponse.isError()) {
                        throw new WeComException("failed to obtain access token");
                    }
                    tokenCache = wecomCacheable.putToken(corpId, agentId, tokenResponse.getAccessToken());
                }
            }
        }
        return tokenCache;
    }

}
