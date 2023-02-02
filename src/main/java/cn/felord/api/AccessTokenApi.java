package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;
import cn.felord.WeComException;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 获取 access_token
 *
 * @author felord.cn
 */
public class AccessTokenApi extends AbstractTokenApi {

    /**
     * Instantiates a new Access token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    AccessTokenApi(WeComTokenCacheable wecomCacheable, AgentDetails agentDetails) {
        super(wecomCacheable, agentDetails);
    }

    @Override
    protected String doGetToken(AgentDetails agentDetails) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                .queryParam("corpid", agentDetails.getCorpId())
                .queryParam("corpsecret", agentDetails.getSecret())
                .build();
        AccessTokenResponse tokenResponse = this.getRestTemplate().getForObject(uriComponents.toUri(), AccessTokenResponse.class);
        if (tokenResponse == null || tokenResponse.isError()) {
            String errorMsg = tokenResponse == null ? "token response is null" : tokenResponse.getErrmsg();
            throw new WeComException("failed to obtain access token,reason: " + errorMsg);
        }
        return tokenResponse.getAccessToken();
    }
}
