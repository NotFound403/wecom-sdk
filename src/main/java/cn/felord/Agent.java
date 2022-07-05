package cn.felord;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type Agent.
 *
 * @author n1
 * @since 2021 /6/17 14:21
 */
@AllArgsConstructor
@Getter
public class Agent implements AgentDetails {
    private final String corpId;
    private final String secret;
    private final String agentId;
}
