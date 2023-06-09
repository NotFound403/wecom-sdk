package cn.felord.api;

/**
 * 企微应用API
 *
 * @author dax
 * @since 2023 /6/9 16:33
 */
public class AgentApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact book manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    AgentApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }


    /**
     * 应用管理
     *
     * @return the agent manager
     */
    public AgentManagerApi agentManager() {
        return this.workWeChatApiClient.retrofit().create(AgentManagerApi.class);
    }

    /**
     * 消息推送
     *
     * @return the message api
     */
    public AgentMessageApi agentMessageApi() {
        return this.workWeChatApiClient.retrofit().create(AgentMessageApi.class);
    }
}
