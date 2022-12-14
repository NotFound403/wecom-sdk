package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.callcenter.KfSessionResponse;
import cn.felord.domain.callcenter.KfSessionUpdateRequest;
import cn.felord.domain.callcenter.SyncMsgRequest;
import cn.felord.domain.callcenter.SyncMsgResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

        String endpoint = WeComEndpoint.KF_SERVICE_STATE_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, String> body = new HashMap<>(2);
        body.put("open_kfid", openKfid);
        body.put("external_userid", externalUserid);
        return workWeChatApiClient.post(uri, body, KfSessionResponse.class);
    }

    /**
     * 变更会话状态
     *
     * @param request the request
     * @return the we com response
     */
    public GenericResponse<String> trans(KfSessionUpdateRequest request) {

        String endpoint = WeComEndpoint.KF_SERVICE_STATE_TRANS.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 读取消息
     *
     * @param request the request
     * @return the sync msg response
     */
    public SyncMsgResponse syncMsg(SyncMsgRequest request) {
        String endpoint = WeComEndpoint.KF_SYNC_MSG.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, SyncMsgResponse.class);
    }
}
