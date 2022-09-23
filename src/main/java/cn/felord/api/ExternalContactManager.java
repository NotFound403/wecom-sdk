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
     * 客户联系「联系我」管理
     *
     * @param agent the agent
     * @return the corp service user api
     */
    public ContactMeWayApi contactMeWayApi(AgentDetails agent) {
        return new ContactMeWayApi(cacheable).agent(agent);
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

    /**
     * 客户朋友圈
     *
     * @param agent the agent
     * @return the moment api
     */
    public MomentApi momentApi(AgentDetails agent) {
        return new MomentApi(cacheable).agent(agent);
    }

    /**
     * 消息推送
     *
     * @param agent the agent
     * @return the message api
     */
    public GroupMessageApi messageApi(AgentDetails agent) {
        return new GroupMessageApi(cacheable).agent(agent);
    }

    /**
     * 统计管理
     *
     * @param agent the agent
     * @return the statistic api
     */
    public StatisticApi statisticApi(AgentDetails agent) {
        return new StatisticApi(cacheable).agent(agent);
    }
}