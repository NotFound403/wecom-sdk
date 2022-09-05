package cn.felord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * The type Agent.
 *
 * @author n1
 * @since 2021 /6/17 14:21
 */
@AllArgsConstructor
@Getter
public class Agent implements AgentDetails {
    @NonNull
    private final String corpId;
    @NonNull
    private final String secret;
    @NonNull
    private final String agentId;
}
