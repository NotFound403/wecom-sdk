package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.RestTemplateFactory;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author xiafang
 */
public class AccessTokenApi {
    private final RestTemplate restTemplate;
    private final AgentDetails agentDetails;


    protected AccessTokenApi(AgentDetails agentDetails) {
        this.restTemplate = RestTemplateFactory.restOperations();
        this.agentDetails = agentDetails;
    }

    public static <A extends AgentDetails> AccessTokenApi agent(A agent) {
        return new AccessTokenApi(agent);
    }


    public String getTokenResponse() {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                .queryParam("corpid", agentDetails.getCorpId())
                .queryParam("corpsecret", agentDetails.getSecret())
                .build();
        AccessTokenResponse tokenResponse = this.restTemplate.getForObject(uriComponents.toUri(), AccessTokenResponse.class);
        if (tokenResponse == null || !tokenResponse.isSuccessful()) {
            throw new RuntimeException("failed to obtain access token");
        }
        return tokenResponse.getAccessToken();
    }

}
