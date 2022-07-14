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
 * @author xiafang
 */
public class AccessTokenApi {
    private static final String KEY_FORMATTER = "qywx::token::{0}::{1}";
    private final RestTemplate restTemplate;
    private final Cacheable cacheable;


    AccessTokenApi(Cacheable cacheable) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.cacheable = cacheable;
    }


    public String getTokenResponse(AgentDetails agentDetails) {
        String key = cacheable.get(MessageFormat.format(KEY_FORMATTER, agentDetails.getCorpId(), agentDetails.getAgentId()));
        String tokenCache = cacheable.get(key);

        if (tokenCache != null) {
            return tokenCache;
        }

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                .queryParam("corpid", agentDetails.getCorpId())
                .queryParam("corpsecret", agentDetails.getSecret())
                .build();
        AccessTokenResponse tokenResponse = this.restTemplate.getForObject(uriComponents.toUri(), AccessTokenResponse.class);
        if (tokenResponse == null || !tokenResponse.isSuccessful()) {
            throw new RuntimeException("failed to obtain access token");
        }
        String accessToken = tokenResponse.getAccessToken();
        cacheable.put(key, accessToken);
        return accessToken;
    }

}
