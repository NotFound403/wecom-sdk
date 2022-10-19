package cn.felord;

import cn.felord.enumeration.NativeAgent;
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
public class DefaultAgent implements AgentDetails {
    @NonNull
    private final String corpId;
    @NonNull
    private final String secret;
    @NonNull
    private final String agentId;


    /**
     * 获取内置基础应用
     *
     * @param corpId the corp id
     * @param secret the secret
     * @param agent  the agent
     * @return the agent details
     */
    public static AgentDetails nativeAgent(String corpId,String secret,NativeAgent agent){
        return new DefaultAgent(corpId,secret, agent.getAgentId());
    }
}
