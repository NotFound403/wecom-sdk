package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComAgentTicketCacheable;

/**
 * The type Work we chat api.
 *
 * @author felord.cn
 */
public final class WorkWeChatApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Work we chat api.
     *
     * @param tokenApi the token api
     */
    WorkWeChatApi(TokenApi tokenApi) {
        this.workWeChatApiClient = new WorkWeChatApiClient(tokenApi);
    }

    /**
     * 获取企业微信API域名IP段
     *
     * @return the domain api
     */
    public DomainApi domainApi() {
        return new DomainApi(workWeChatApiClient);
    }

    /**
     * 通讯录管理
     *
     * @return the Address book Manager
     */
    public ContactBookManager contactBookManager() {
        return new ContactBookManager(workWeChatApiClient);
    }

    /**
     * 客户联系
     *
     * @return the external contact manager
     */
    public ExternalContactManager externalContactManager() {
        return new ExternalContactManager(workWeChatApiClient);
    }

    /**
     * 微信客服
     *
     * @return the call center manager
     */
    public CallCenterManager callCenterManager() {
        return new CallCenterManager(workWeChatApiClient);
    }

    /**
     * 身份验证
     *
     * @return the auth api
     */
    public AuthApi authApi() {
        return new AuthApi(workWeChatApiClient);
    }

    /**
     * 应用管理
     *
     * @return the agent manager
     */
    public AgentManager agentManager() {
        return new AgentManager(workWeChatApiClient);
    }

    /**
     * SDK ticket相关接口
     *
     * @param weComAgentTicketCacheable the weComAgentTicketCacheable
     * @return the sdk ticket api
     */
    public SdkTicketApi sdkTicketApi(WeComAgentTicketCacheable weComAgentTicketCacheable) {
        return new SdkTicketApi(workWeChatApiClient, weComAgentTicketCacheable);
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
     * @return the media api
     */
    public MediaApi mediaApi() {
        return new MediaApi(workWeChatApiClient);
    }
}
