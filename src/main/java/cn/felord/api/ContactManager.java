package cn.felord.api;

import cn.felord.Agent;
import cn.felord.Cacheable;

/**
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactManager {
    private final Cacheable cacheable;

    ContactManager(Cacheable cacheable) {
        this.cacheable = cacheable;
    }

    public UserApi userApi(Agent agent) {
        return new UserApi(cacheable).agent(agent);
    }

    public DepartmentApi departmentApi(Agent agent) {
        return new DepartmentApi(cacheable).agent(agent);
    }

    public TagApi tagApi(Agent agent) {
        return new TagApi(cacheable).agent(agent);
    }

    public AsynchronousBatchApi asynchronousBatchApi(Agent agent) {
        return new AsynchronousBatchApi(cacheable).agent(agent);
    }
}
