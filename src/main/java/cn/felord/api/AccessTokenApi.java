package cn.felord.api;

import cn.felord.RestTemplateFactory;
import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;

/**
 * @author xiafang
 */
public class AccessTokenApi {
    private static final String KEY_FORMATTER = "qywx::token::{0}::{1}";
    private final RestTemplate restTemplate;
    private final TokenCacheable tokenCacheable;


    AccessTokenApi(TokenCacheable tokenCacheable) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.tokenCacheable = tokenCacheable;
    }


    public synchronized String getTokenResponse(AgentDetails agentDetails) {
        String key = MessageFormat.format(KEY_FORMATTER, agentDetails.getCorpId(), agentDetails.getAgentId());
        String tokenCache = tokenCacheable.get(key);
        if (tokenCache == null) {
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                    .queryParam("corpid", agentDetails.getCorpId())
                    .queryParam("corpsecret", agentDetails.getSecret())
                    .build();
            AccessTokenResponse tokenResponse = this.restTemplate.getForObject(uriComponents.toUri(), AccessTokenResponse.class);
            if (tokenResponse == null || !tokenResponse.isSuccessful()) {
                throw new RuntimeException("failed to obtain access token");
            }
            tokenCache = tokenCacheable.put(key, tokenResponse.getAccessToken());
        }

        return tokenCache;
    }

}
