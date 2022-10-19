package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComAgentTicketCacheable;
import cn.felord.WeComTokenCacheable;

/**
 * The type Work we chat api.
 *
 * @author felord.cn
 */
public final class WorkWeChatApi {

    private final WeComTokenCacheable weComTokenCacheable;


    /**
     * Instantiates a new Work we chat api.
     *
     * @param weComTokenCacheable the we com token cacheable
     */
    public WorkWeChatApi(WeComTokenCacheable weComTokenCacheable) {
        this.weComTokenCacheable = weComTokenCacheable;
    }


    /**
     * 获取企业微信API域名IP段
     *
     * @param agentDetails the agent details
     * @return the domain api
     */
    public DomainApi domainApi(AgentDetails agentDetails) {
        return new DomainApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 通讯录管理
     *
     * @param agentDetails the agent details
     * @return the Address book Manager
     */
    public ContactBookManager contactBookManager(AgentDetails agentDetails) {
        return new ContactBookManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 客户联系
     *
     * @param agentDetails the agent details
     * @return the external contact manager
     */
    public ExternalContactManager externalContactManager(AgentDetails agentDetails) {
        return new ExternalContactManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 微信客服
     *
     * @param agentDetails the agent details
     * @return the call center manager
     */
    public CallCenterManager callCenterManager(AgentDetails agentDetails) {
        return new CallCenterManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 身份验证
     *
     * @param agentDetails the agent details
     * @return the auth api
     */
    public AuthApi authApi(AgentDetails agentDetails) {
        return new AuthApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 应用管理
     *
     * @param agentDetails the agent details
     * @return the agent manager
     */
    public AgentManager agentManager(AgentDetails agentDetails) {
        return new AgentManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * SDK ticket相关接口
     *
     * @param agentDetails              the agent details
     * @param weComAgentTicketCacheable the weComAgentTicketCacheable
     * @return the sdk ticket api
     */
    public SdkTicketApi sdkTicketApi(AgentDetails agentDetails, WeComAgentTicketCacheable weComAgentTicketCacheable) {
        return new SdkTicketApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)), weComAgentTicketCacheable);
    }

    /**
     * 效率工具相关接口
     *
     * @param agentDetails the agent details
     * @return the schedule api
     */
    public ScheduleApi scheduleApi(AgentDetails agentDetails){
        return new ScheduleApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable,agentDetails)));
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
     * @param agentDetails the agent details
     * @return the media api
     */
    public MediaApi mediaApi(AgentDetails agentDetails) {
        return new MediaApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }
}
