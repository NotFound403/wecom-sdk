package cn.felord.api;

import cn.felord.domain.callcenter.KfServicerListResponse;
import cn.felord.domain.callcenter.KfServicerRequest;
import cn.felord.domain.callcenter.KfServicerResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 接待人员管理
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public class KfServicerApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Kf servicer api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    KfServicerApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 添加接待人员
     *
     * @param request the request
     * @return the generic response
     */
    public KfServicerResponse addKfServicer(KfServicerRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICER_CREATE, request, KfServicerResponse.class);
    }

    /**
     * 删除接待人员
     *
     * @param request the request
     * @return the we com response
     */
    public KfServicerResponse delKfServicer(KfServicerRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICER_DEL, request, KfServicerResponse.class);
    }

    /**
     * 获取接待人员列表
     *
     * @param openKfid the openKfid
     * @return the generic response
     */
    public KfServicerListResponse kfServicerList(String openKfid) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("open_kfid", openKfid);
        return workWeChatApiClient.get(WeComEndpoint.KF_SERVICER_LIST, query, KfServicerListResponse.class);
    }
}
