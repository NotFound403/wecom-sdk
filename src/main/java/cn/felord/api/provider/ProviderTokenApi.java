package cn.felord.api.provider;

import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;
import cn.felord.WeComException;
import cn.felord.api.AbstractTokenApi;
import cn.felord.domain.authentication.ProviderTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取服务商凭证
 *
 * @author felord.cn
 */
public class ProviderTokenApi extends AbstractTokenApi {

    /**
     * Instantiates a new Access token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    ProviderTokenApi(WeComTokenCacheable wecomCacheable, AgentDetails agentDetails) {
        super(wecomCacheable, agentDetails);
    }


    @Override
    protected String doGetToken(AgentDetails agentDetails) {
        String endpoint = WeComEndpoint.SERVICE_GET_PROVIDER_TOKEN.endpoint();
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build();
        Map<String, String> body = new HashMap<>(2);
        body.put("corpid", agentDetails.getCorpId());
        body.put("provider_secret", agentDetails.getSecret());
        ProviderTokenResponse tokenResponse = this.getRestTemplate().postForObject(uriComponents.toUri(), body, ProviderTokenResponse.class);
        if (tokenResponse == null || tokenResponse.isError()) {
            throw new WeComException("failed to obtain provider token");
        }
        return tokenResponse.getProviderAccessToken();
    }

}
