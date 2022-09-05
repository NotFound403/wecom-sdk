package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.Cacheable;
import cn.felord.RestTemplateFactory;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;

/**
 * @author felord.cn
 */
public class AccessTokenApi {
    private final RestTemplate restTemplate;
    private final Cacheable cacheable;


    AccessTokenApi(Cacheable cacheable) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.cacheable = cacheable;
    }


    public synchronized String getTokenResponse(AgentDetails agentDetails) {
        String corpId = agentDetails.getCorpId();
        String agentId = agentDetails.getAgentId();
        String tokenCache = cacheable.getToken(corpId,agentId);
        if (tokenCache == null) {
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                    .queryParam("corpid", corpId)
                    .queryParam("corpsecret", agentDetails.getSecret())
                    .build();
            AccessTokenResponse tokenResponse = this.restTemplate.getForObject(uriComponents.toUri(), AccessTokenResponse.class);
            if (tokenResponse == null || !tokenResponse.isSuccessful()) {
                throw new RuntimeException("failed to obtain access token");
            }
            tokenCache = cacheable.putToken(corpId,agentId, tokenResponse.getAccessToken());

        }
        return tokenCache;
    }

}
