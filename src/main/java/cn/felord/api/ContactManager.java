package cn.felord.api;

import cn.felord.Agent;
import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;

/**
 * @author dax
 * @since 1.0.14.RELEASE
 */
public class ContactManager {
    private final TokenCacheable tokenCacheable;

    ContactManager(TokenCacheable tokenCacheable) {
        this.tokenCacheable = tokenCacheable;
    }

    public UserApi userApi(AgentDetails agent) {
        return new UserApi(tokenCacheable).agent(agent);
    }

    public DepartmentApi departmentApi(AgentDetails agent) {
        return new DepartmentApi(tokenCacheable).agent(agent);
    }

    public TagApi tagApi(AgentDetails agent) {
        return new TagApi(tokenCacheable).agent(agent);
    }

    public AsynchronousBatchApi asynchronousBatchApi(Agent agent) {
        return new AsynchronousBatchApi(tokenCacheable).agent(agent);
    }
}
