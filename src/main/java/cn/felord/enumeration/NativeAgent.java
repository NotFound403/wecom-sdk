package cn.felord.enumeration;

/**
 * The enum Native agent.
 *
 * @author dax
 * @since 2021 /12/9 14:12
 */
public enum NativeAgent {
    /**
     * 通讯录同步助手
     */
    CONTACT("2000002", "通讯录同步助手"),
    /**
     * 外部联系人
     */
    EXTERNAL("2000003", "外部联系人"),
    /**
     * 打卡
     */
    ATTENDANCE("3010011", "打卡"),
    /**
     * 审批
     */
    APPROVAL("3010040", "审批"),
    /**
     * 汇报
     */
    WORKNOTE("3010041", "汇报"),
    /**
     * 企业支付
     */
    PAY("3010046", "企业支付"),
    /**
     * 日程
     */
    SCHEDULE("3010084", "日程"),
    /**
     * 上下游
     */
    CORP_CHAIN("3010168", "上下游"),
    /**
     * 公告
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
