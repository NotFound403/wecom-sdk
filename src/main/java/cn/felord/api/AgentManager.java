package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentSettingRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.util.LinkedMultiValueMap;
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
     * @return the agent details
     */
    public AgentDetailsResponse getAgentDetails() {
        String endpoint = WeComEndpoint.AGENT_DETAILS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("agentid", workWeChatApiClient.getAgentDetails().getAgentId())
                .build()
                .toUri();
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("agentid", workWeChatApiClient.getAgentDetails().getAgentId());
        return workWeChatApiClient.get(WeComEndpoint.AGENT_DETAILS, query, AgentDetailsResponse.class);
    }

    /**
     * Sets.
     *
     * @param request the request
     * @return the
     */
    public WeComResponse settings(AgentSettingRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.AGENT_SETTINGS, request, WeComResponse.class);
    }
}
