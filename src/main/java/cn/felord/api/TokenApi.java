package cn.felord.api;

import cn.felord.AgentDetails;

/**
 * The interface Token api.
 *
 * @author dax
 * @since 2022 /10/7 17:33
 */
public interface TokenApi {
    /**
     * Gets token response.
     *
     * @return the token response
     */
    String getTokenResponse();

    /**
     * Gets agent details.
     *
     * @return the agent details
     */
    AgentDetails getAgentDetails();
}
