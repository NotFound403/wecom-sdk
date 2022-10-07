package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.WeComException;
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
    ProviderTokenApi(WeComCacheable wecomCacheable, AgentDetails agentDetails) {
        super(wecomCacheable, agentDetails);
    }


    @Override
    protected String doGetToken(AgentDetails agentDetails) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.SERVICE_GET_PROVIDER_TOKEN.endpoint())
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
