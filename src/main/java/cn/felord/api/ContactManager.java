package cn.felord.api;

import cn.felord.Agent;
import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;

/**
 * The type Contact manager.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactManager {
    private final WeComCacheable wecomCacheable;

    /**
     * Instantiates a new Contact manager.
     *
     * @param wecomCacheable the cacheable
     */
    ContactManager(WeComCacheable wecomCacheable) {
        this.wecomCacheable = wecomCacheable;
    }

    /**
     * User api user api.
     *
     * @param agent the agent
     * @return the user api
     */
    public UserApi userApi(AgentDetails agent) {
        return new UserApi(wecomCacheable).agent(agent);
    }

    /**
     * Department api department api.
     *
     * @param agent the agent
     * @return the department api
     */
    public DepartmentApi departmentApi(AgentDetails agent) {
        return new DepartmentApi(wecomCacheable).agent(agent);
    }

    /**
     * Tag api tag api.
     *
     * @param agent the agent
     * @return the tag api
     */
    public TagApi tagApi(AgentDetails agent) {
        return new TagApi(wecomCacheable).agent(agent);
    }

    /**
     * Asynchronous batch api asynchronous batch import api.
     *
     * @param agent the agent
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi(Agent agent) {
        return new AsynchronousBatchImportApi(wecomCacheable).agent(agent);
    }

    /**
     * Linked corp api linked corp api.
     *
     * @param agent the agent
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi(Agent agent) {
        return new LinkedCorpApi(wecomCacheable).agent(agent);
    }
}
