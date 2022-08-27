package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentSettingRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author dax
 * @since 1.0.14.RELEASE
 */
public class AgentManager extends AbstractApi {
    private String agentId;

    /**
     * Instantiates a new We com client.
     *
     * @param tokenCacheable
     */
    AgentManager(TokenCacheable tokenCacheable) {
        super(tokenCacheable);
    }

    AgentManager agent(AgentDetails agent) {
        String agentId = agent.getAgentId();
        Assert.hasText(agentId, "agentid must not be null");
        this.withAgent(agent);
        this.agentId = agentId;
        return this;
    }

    public AgentDetailsResponse getAgentDetails() {
        String endpoint = WeComEndpoint.AGENT_DETAILS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("agentid", agentId)
                .build()
                .toUri();
        return this.get(uri, AgentDetailsResponse.class);
    }

    public WeComResponse settings(AgentSettingRequest request) {
        request.setAgentid(Integer.valueOf(agentId));
        String endpoint = WeComEndpoint.AGENT_SETTINGS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }
}
