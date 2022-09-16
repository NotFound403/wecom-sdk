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
    private final WeComCacheable cacheable;

    /**
     * 获取企业微信API域名IP段
     *
     * @param agent the agent
     * @return the domain api
     */
    public DomainApi domainApi(AgentDetails agent) {
        return new DomainApi(cacheable).agent(agent);
    }

    /**
     * 通讯录管理
     *
     * @return the contact manager
     */
    public ContactManager contactManager() {
        return new ContactManager(cacheable);
    }

    /**
     * 客户联系
     *
     * @return the external contact manager
     */
    public ExternalContactManager externalContactManager() {
        return new ExternalContactManager(cacheable);
    }

    /**
     * 身份验证
     *
     * @param agent the agent
     * @return the auth api
     */
    public AuthApi authApi(AgentDetails agent) {
        return new AuthApi(cacheable).agent(agent);
    }

    /**
     * 应用管理
     *
     * @param agent the agent
     * @return the agent manager
     */
    public AgentManager agentManager(AgentDetails agent) {
        return new AgentManager(cacheable).agent(agent);
    }

    /**
     * SDK ticket相关接口
     *
     * @param agent the agent
     * @return the sdk ticket api
     */
    public SdkTicketApi sdkTicketApi(AgentDetails agent) {
        return new SdkTicketApi(cacheable).agent(agent);
    }

    /**
     * Webhook相关接口
     *
     * @return the webhook api
     */
    public static WebhookApi webhookApi() {
        return new WebhookApi();
    }

    /**
     * 素材接口
     *
     * @param agent the agent
     * @return the media api
     */
    public MediaApi mediaApi(AgentDetails agent) {
        return new MediaApi(cacheable).agent(agent);
    }
}
