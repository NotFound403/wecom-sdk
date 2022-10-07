package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;

/**
 * 通讯录管理
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactBookManager {
    private final WeComCacheable cacheable;

    /**
     * Instantiates a new Contact manager.
     *
     * @param cacheable the cacheable
     */
    ContactBookManager(WeComCacheable cacheable) {
        this.cacheable = cacheable;
    }

    /**
     * 成员管理
     *
     * @param agent the agent
     * @return the user api
     */
    public UserApi userApi(AgentDetails agent) {
        return new UserApi(cacheable, agent);
    }

    /**
     * 部门管理
     *
     * @param agent the agent
     * @return the department api
     */
    public DepartmentApi departmentApi(AgentDetails agent) {
        return new DepartmentApi(cacheable, agent);
    }

    /**
     * 标签管理
     *
     * @param agent the agent
     * @return the tag api
     */
    public TagApi tagApi(AgentDetails agent) {
        return new TagApi(cacheable, agent);
    }

    /**
     * 异步导入接口
     *
     * @param agent the agent
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi(AgentDetails agent) {
        return new AsynchronousBatchImportApi(cacheable, agent);
    }

    /**
     * 互联企业接口
     *
     * @param agent the agent
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi(AgentDetails agent) {
        return new LinkedCorpApi(cacheable, agent);
    }
}
