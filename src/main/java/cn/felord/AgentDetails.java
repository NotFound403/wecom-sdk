package cn.felord;

/**
 * The interface Agent details.
 *
 * @author n1
 * @since 2021 /6/17 10:15
 */
public interface AgentDetails {
    /**
     * 企业ID
     *
     * @return the corpId
     */
    String getCorpId();

    /**
     * 应用秘钥或者管理秘钥
     *
     * @return the corp secret
     */
    String getSecret();

    /**
     * 应用ID，内置应用需要虚拟化一个ID
     *
     * @return the agent id
     */
    String getAgentId();

}
