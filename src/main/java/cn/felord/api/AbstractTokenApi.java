package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.RestTemplateFactory;
import cn.felord.WeComCacheable;
import org.springframework.web.client.RestTemplate;

/**
 * The type Token api.
 *
 * @author xiafang
 * @since 2022 /10/7 15:19
 */
public abstract class AbstractTokenApi implements TokenApi {
    private final WeComCacheable wecomCacheable;
    private final AgentDetails agentDetails;
    private final RestTemplate restTemplate;


    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    AbstractTokenApi(WeComCacheable wecomCacheable, AgentDetails agentDetails) {
        this.wecomCacheable = wecomCacheable;
        this.agentDetails = agentDetails;
        this.restTemplate = RestTemplateFactory.restOperations();
    }

    /**
     * Gets token response.
     *
     * @return the token response
     */
    @Override
    public final String getTokenResponse() {
        String corpId = agentDetails.getCorpId();
        final String agentId = agentDetails.getAgentId();
        String tokenCache = wecomCacheable.getAccessToken(corpId, agentId);
        if (tokenCache == null) {
            synchronized (this) {
                tokenCache = wecomCacheable.getAccessToken(corpId, agentId);
                if (tokenCache == null) {
                    tokenCache = wecomCacheable.putAccessToken(corpId, agentId, doGetToken(agentDetails));
                }
            }
        }
        return tokenCache;
    }

    /**
     * Gets rest template.
     *
     * @return the rest template
     */
    RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * Do get token string.
     *
     * @param agentDetails the agent details
     * @return the string
     */
    protected abstract String doGetToken(AgentDetails agentDetails);

}
