package cn.felord.api;

/**
 * The type Office api.
 *
 * @author dax
 * @since 2023 /3/13 16:22
 */
public class WedocApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Office api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    WedocApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 收集表
     *
     * @return the form api
     */
    public FormApi formApi() {
        return new FormApi(workWeChatApiClient);
    }

}
