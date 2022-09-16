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
    private final WeComCacheable cacheable;

    /**
     * Instantiates a new Contact manager.
     *
     * @param cacheable the cacheable
     */
    ContactManager(WeComCacheable cacheable) {
        this.cacheable = cacheable;
    }

    /**
     * 成员管理
     *
     * @param agent the agent
     * @return the user api
     */
    public UserApi userApi(AgentDetails agent) {
        return new UserApi(cacheable).agent(agent);
    }

    /**
     * 部门管理
     *
     * @param agent the agent
     * @return the department api
     */
    public DepartmentApi departmentApi(AgentDetails agent) {
        return new DepartmentApi(cacheable).agent(agent);
    }

    /**
     * 标签管理
     *
     * @param agent the agent
     * @return the tag api
     */
    public TagApi tagApi(AgentDetails agent) {
        return new TagApi(cacheable).agent(agent);
    }

    /**
     * 异步导入接口
     *
     * @param agent the agent
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi(Agent agent) {
        return new AsynchronousBatchImportApi(cacheable).agent(agent);
    }

    /**
     * 互联企业接口
     *
     * @param agent the agent
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi(Agent agent) {
        return new LinkedCorpApi(cacheable).agent(agent);
    }
}
