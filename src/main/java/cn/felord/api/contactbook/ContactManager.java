package cn.felord.api.contactbook;

import cn.felord.Agent;

/**
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactManager {

    public UserApi userApi(Agent agent) {
        return UserApi.agent(agent);
    }

    public DepartmentApi departmentApi(Agent agent) {
        return DepartmentApi.agent(agent);
    }

    public TagApi tagApi(Agent agent) {
        return TagApi.agent(agent);
    }

    public AsynchronousBatchApi asynchronousBatchApi(Agent agent) {
        return AsynchronousBatchApi.agent(agent);
    }
}
