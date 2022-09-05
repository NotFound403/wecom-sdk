package cn.felord.api;

import cn.felord.Agent;
import cn.felord.AgentDetails;
import cn.felord.Cacheable;

/**
 * The type Contact manager.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactManager {
    private final Cacheable cacheable;

    /**
     * Instantiates a new Contact manager.
     *
     * @param cacheable the cacheable
     */
    ContactManager(Cacheable cacheable) {
        this.cacheable = cacheable;
    }

    /**
     * User api user api.
     *
     * @param agent the agent
     * @return the user api
     */
    public UserApi userApi(AgentDetails agent) {
        return new UserApi(cacheable).agent(agent);
    }

    /**
     * Department api department api.
     *
     * @param agent the agent
     * @return the department api
     */
    public DepartmentApi departmentApi(AgentDetails agent) {
        return new DepartmentApi(cacheable).agent(agent);
    }

    /**
     * Tag api tag api.
     *
     * @param agent the agent
     * @return the tag api
     */
    public TagApi tagApi(AgentDetails agent) {
        return new TagApi(cacheable).agent(agent);
    }

    /**
     * Asynchronous batch api asynchronous batch import api.
     *
     * @param agent the agent
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi(Agent agent) {
        return new AsynchronousBatchImportApi(cacheable).agent(agent);
    }

    /**
     * Linked corp api linked corp api.
     *
     * @param agent the agent
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi(Agent agent) {
        return new LinkedCorpApi(cacheable).agent(agent);
    }
}
