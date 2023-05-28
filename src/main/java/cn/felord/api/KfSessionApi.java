package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.callcenter.KfSessionResponse;
import cn.felord.domain.callcenter.KfSessionUpdateRequest;
import cn.felord.domain.callcenter.SyncMsgRequest;
import cn.felord.domain.callcenter.SyncMsgResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * 会话分配与消息收发
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public class KfSessionApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Kf session api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    KfSessionApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取会话状态
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @return the generic response
     */
    public KfSessionResponse getSessionState(String openKfid, String externalUserid) {
        Map<String, String> body = new HashMap<>(2);
        body.put("open_kfid", openKfid);
        body.put("external_userid", externalUserid);
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICE_STATE_GET, body, KfSessionResponse.class);
    }

    /**
     * 变更会话状态
     *
     * @param request the request
     * @return the we com response
     */
    public GenericResponse<String> trans(KfSessionUpdateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SERVICE_STATE_TRANS, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 读取消息
     *
     * @param request the request
     * @return the sync msg response
     */
    public SyncMsgResponse syncMsg(SyncMsgRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.KF_SYNC_MSG, request, SyncMsgResponse.class);
    }
}
