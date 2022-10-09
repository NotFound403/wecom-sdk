package cn.felord.api;

/**
 * 微信客服
 *
 * @author dax
 * @since 2021 /7/26 13:42
 */
public class CallCenterManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Call center manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    CallCenterManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 客服账号管理
     *
     * @return the service account manager api
     */
    public KfAccountApi kfAccountApi() {
        return new KfAccountApi(workWeChatApiClient);
    }

    /**
     * 接待人员管理
     *
     * @return the kf servicer api
     */
    public KfServicerApi kfServicerApi() {
        return new KfServicerApi(workWeChatApiClient);
    }

    /**
     * 会话分配与消息收发
     *
     * @return the kf session api
     */
    public KfSessionApi kfSessionApi() {
        return new KfSessionApi(workWeChatApiClient);
    }

}
