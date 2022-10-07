package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentSettingRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * The type Agent manager.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class AgentManager extends AbstractAgentApi {
    private final String agentId;

    /**
     * Instantiates a new We com client.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agent          the agent
     */
    AgentManager(WeComCacheable wecomCacheable, AgentDetails agent) {
        super(wecomCacheable, agent);
        String agentId = agent.getAgentId();
        Assert.hasText(agentId, "agentid must not be null");
        this.agentId = agentId;
    }

    /**
     * Gets agent details.
     *
     * @return the agent details
     */
    public AgentDetailsResponse getAgentDetails() {
        return this.getAgentDetails(agentId);
    }

    /**
     * Gets agent details.
     *
     * @param agentId the agent id
     * @return the agent details
     */
    public AgentDetailsResponse getAgentDetails(String agentId) {
        String endpoint = WeComEndpoint.AGENT_DETAILS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("agentid", agentId)
                .build()
                .toUri();
        return this.get(uri, AgentDetailsResponse.class);
    }

    /**
     * Sets.
     *
     * @param request the request
     * @return the
     */
    public WeComResponse settings(AgentSettingRequest request) {
        request.setAgentid(Integer.valueOf(agentId));
        String endpoint = WeComEndpoint.AGENT_SETTINGS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, WeComResponse.class);
    }
}
