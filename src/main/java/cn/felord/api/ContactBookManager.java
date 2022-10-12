package cn.felord.api;

/**
 * 通讯录管理
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ContactBookManager {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact book manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ContactBookManager(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 成员管理
     *
     * @return the user api
     */
    public UserApi userApi() {
        return new UserApi(workWeChatApiClient);
    }

    /**
     * 部门管理
     *
     * @return the department api
     */
    public DepartmentApi departmentApi() {
        return new DepartmentApi(workWeChatApiClient);
    }

    /**
     * 标签管理
     *
     * @return the tag api
     */
    public TagApi tagApi() {
        return new TagApi(workWeChatApiClient);
    }

    /**
     * 异步导入接口
     *
     * @return the asynchronous batch import api
     */
    public AsynchronousBatchImportApi asynchronousBatchApi() {
        return new AsynchronousBatchImportApi(workWeChatApiClient);
    }

    /**
     * 互联企业接口
     *
     * @return the linked corp api
     */
    public LinkedCorpApi linkedCorpApi() {
        return new LinkedCorpApi(workWeChatApiClient);
    }
}
