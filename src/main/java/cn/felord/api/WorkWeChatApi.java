package cn.felord.api;

import cn.felord.Cacheable;
import lombok.AllArgsConstructor;

/**
 * @author xiafang
 */
@AllArgsConstructor
public final class WorkWeChatApi {
    private final Cacheable cacheable;

    public DomainApi domainApi() {
        return new DomainApi(cacheable);
    }

    public ContactManager contactManager() {
        return new ContactManager(cacheable);
    }

    public AgentManager agentManager() {
        return new AgentManager(cacheable);
    }

    public SdkTicketApi ticketApi() {
        return new SdkTicketApi(cacheable);
    }

    public WebhookApi webhookApi() {
        return new WebhookApi(cacheable);
    }

    public MediaApi mediaApi() {
        return new MediaApi(cacheable);
    }

    public AccessTokenApi accessTokenApi() {
        return new AccessTokenApi(cacheable);
    }
}
