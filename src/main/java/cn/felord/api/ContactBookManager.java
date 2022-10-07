package cn.felord.api;

import cn.felord.AgentDetails;

/**
 * 通讯录管理
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactBookManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact book manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ContactBookManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 成员管理
     *
     * @param agent the agent
     * @return the user api
     */
    public UserApi userApi(AgentDetails agent) {
        return new UserApi(workWeChatApiClient);
    }

    /**
     * 部门管理
     *
     * @param agent the agent
     * @return the department api
     */
    public DepartmentApi departmentApi(AgentDetails agent) {
        return new DepartmentApi(workWeChatApiClient);
    }

    /**
     * 标签管理
     *
     * @param agent the agent
     * @return the tag api
     */
    public TagApi tagApi(AgentDetails agent) {
        return new TagApi(workWeChatApiClient);
    }

    /**
     * 异步导入接口
     *
     * @param agent the agent
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi(AgentDetails agent) {
        return new AsynchronousBatchImportApi(workWeChatApiClient);
    }

    /**
     * 互联企业接口
     *
     * @param agent the agent
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi(AgentDetails agent) {
        return new LinkedCorpApi(workWeChatApiClient);
    }
}
