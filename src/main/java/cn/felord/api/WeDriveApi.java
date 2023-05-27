package cn.felord.api;

/**
 * @author dax
 * @since 2023/3/17 15:01
 */
public class WeDriveApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    WeDriveApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 管理文件
     *
     * @return the form api
     */
    public FileManagerApi fileManagerApi() {
        return new FileManagerApi(workWeChatApiClient);
    }
}
