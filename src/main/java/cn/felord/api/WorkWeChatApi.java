package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import lombok.AllArgsConstructor;

/**
 * The type Work we chat api.
 *
 * @author felord.cn
 */
@AllArgsConstructor
public final class WorkWeChatApi {
    private final WeComCacheable wecomCacheable;

    /**
     * 获取企业微信API域名IP段
     *
     * @param agent the agent
     * @return the domain api
     */
    public DomainApi domainApi(AgentDetails agent) {
        return new DomainApi(wecomCacheable).agent(agent);
    }

    /**
     * 通讯录管理
     *
     * @return the contact manager
     */
    public ContactManager contactManager() {
        return new ContactManager(wecomCacheable);
    }

    /**
     * 身份验证
     *
     * @param agent the agent
     * @return the auth api
     */
    public AuthApi authApi(AgentDetails agent) {
        return new AuthApi(wecomCacheable).agent(agent);
    }

    /**
     * 应用管理
     *
     * @param agent the agent
     * @return the agent manager
     */
    public AgentManager agentManager(AgentDetails agent) {
        return new AgentManager(wecomCacheable).agent(agent);
    }

    /**
     * SDK ticket相关接口
     *
     * @param agent the agent
     * @return the sdk ticket api
     */
    public SdkTicketApi sdkTicketApi(AgentDetails agent) {
        return new SdkTicketApi(wecomCacheable).agent(agent);
    }

    /**
     * Webhook相关接口
     *
     * @return the webhook api
     */
    public WebhookApi webhookApi() {
        return new WebhookApi();
    }

    /**
     * 素材接口
     *
     * @param agent the agent
     * @return the media api
     */
    public MediaApi mediaApi(AgentDetails agent) {
        return new MediaApi(wecomCacheable).agent(agent);
    }
}
