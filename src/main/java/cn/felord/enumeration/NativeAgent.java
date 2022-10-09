package cn.felord.enumeration;

/**
 * The enum Native agent.
 *
 * @author dax
 * @since 2021 /12/9 14:12
 */
public enum NativeAgent {
    /**
     * Contact native agent.
     */
    CONTACT("2000002", "通讯录同步助手"),
    /**
     * External native agent.
     */
    EXTERNAL("2000003", "外部联系人"),
    /**
     * Announcement native agent.
     */
    ANNOUNCEMENT("3010001", "公告");

    private final String agentId;
    private final String name;

    NativeAgent(String agentId, String name) {
        this.agentId = agentId;
        this.name = name;
    }

    /**
     * Gets agent id.
     *
     * @return the agent id
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
