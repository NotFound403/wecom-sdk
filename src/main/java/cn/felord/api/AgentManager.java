package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentSettingRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * The type Agent manager.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class AgentManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Agent manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    AgentManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
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
        return workWeChatApiClient.get(uri, AgentDetailsResponse.class);
    }

    /**
     * Sets.
     *
     * @param request the request
     * @return the
     */
    public WeComResponse settings(AgentSettingRequest request) {
        String endpoint = WeComEndpoint.AGENT_SETTINGS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }
}
