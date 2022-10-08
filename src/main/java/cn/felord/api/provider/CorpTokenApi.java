package cn.felord.api.provider;

import cn.felord.AgentDetails;
import cn.felord.WeComException;
import cn.felord.WeComTokenCacheable;
import cn.felord.api.AbstractTokenApi;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 获取企业 access_token
 *
 * @author felord.cn
 */
public class CorpTokenApi extends AbstractTokenApi {

    /**
     * Instantiates a new Access token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    CorpTokenApi(WeComTokenCacheable wecomCacheable, AgentDetails agentDetails) {
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
            throw new WeComException("failed to obtain access token");
        }
        return tokenResponse.getAccessToken();
    }
}
