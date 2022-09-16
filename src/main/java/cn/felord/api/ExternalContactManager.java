package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;

/**
 * 客户联系
 *
 * @author dax
 * @since 2021 /9/8 8:36
 */
public class ExternalContactManager {
    private final WeComCacheable cacheable;

    /**
     * Instantiates a new External contact manager.
     *
     * @param cacheable the cacheable
     */
    ExternalContactManager(WeComCacheable cacheable) {
        this.cacheable = cacheable;
    }

    /**
     * 企业服务人员管理
     *
     * @param agent the agent
     * @return the corp service user api
     */
    public ContactWayApi contactWayApi(AgentDetails agent) {
        return new ContactWayApi(cacheable).agent(agent);
    }

    /**
     * 客户管理
     *
     * @param agent the agent
     * @return the external contact user api
     */
    public ExternalContactUserApi externalContactUserApi(AgentDetails agent) {
        return new ExternalContactUserApi(cacheable).agent(agent);
    }

    /**
     * 管理企业标签
     *
     * @param agent the agent
     * @return the corp tag api
     */
    public CorpTagApi corpTagApi(AgentDetails agent) {
        return new CorpTagApi(cacheable).agent(agent);
    }

    /**
     * 在职继承
     *
     * @param agent the agent
     * @return the on transfer api
     */
    public OnTransferApi onTransferApi(AgentDetails agent) {
        return new OnTransferApi(cacheable).agent(agent);
    }

    /**
     * 离职继承
     *
     * @param agent the agent
     * @return the off transfer api
     */
    public OffTransferApi offTransferApi(AgentDetails agent) {
        return new OffTransferApi(cacheable).agent(agent);
    }

    /**
     * 客户群管理
     *
     * @param agent the agent
     * @return the groupchat api
     */
    public GroupChatApi groupchatApi(AgentDetails agent) {
        return new GroupChatApi(cacheable).agent(agent);
    }
}
