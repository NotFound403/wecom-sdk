package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;
import lombok.AllArgsConstructor;

/**
 * @author xiafang
 */
@AllArgsConstructor
public final class WorkWeChatApi {
    private final TokenCacheable tokenCacheable;

    public DomainApi domainApi(AgentDetails agent) {
        return new DomainApi(tokenCacheable).agent(agent);
    }

    public ContactManager contactManager() {
        return new ContactManager(tokenCacheable);
    }

    public AgentManager agentManager(AgentDetails agent) {
        return new AgentManager(tokenCacheable).agent(agent);
    }

    public SdkTicketApi sdkTicketApi(AgentDetails agent) {
        return new SdkTicketApi(tokenCacheable).agent(agent);
    }

    public WebhookApi webhookApi() {
        return new WebhookApi(tokenCacheable);
    }

    public MediaApi mediaApi(AgentDetails agent) {
        return new MediaApi(tokenCacheable).agent(agent);
    }

    public AccessTokenApi accessTokenApi() {
        return new AccessTokenApi(tokenCacheable);
    }
}
