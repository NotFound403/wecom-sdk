package cn.felord.api;

import cn.felord.domain.urgentcall.CallResponse;
import cn.felord.domain.urgentcall.CallStateRequest;
import cn.felord.domain.urgentcall.CallStateResponse;
import cn.felord.domain.urgentcall.CalleeUsers;
import cn.felord.enumeration.WeComEndpoint;

import java.util.Set;

/**
 * 紧急通知API
 * <p>
 * 【医疗行业】的企业，可通过语音电话提醒员工查看应用推送的重要消息，以便尽快处理紧急事件
 *
 * @author dax
 * @since 2023 /5/31 12:44
 */
public class UrgentCallApi {

    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Urgent call api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    UrgentCallApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 发起语音电话
     * <p>
     * 通过此接口发起语音电话，提醒员工查看应用推送的重要消息
     *
     * @param callUsers the call users
     * @return the call response
     */
    public CallResponse call(Set<String> callUsers) {
        CalleeUsers calleeUsers = new CalleeUsers(callUsers);
        return workWeChatApiClient.post(WeComEndpoint.PSTNCC_CALL, calleeUsers, CallResponse.class);
    }

    /**
     * 获取接听状态
     *
     * @param calleeUserId the callee user id
     * @param callId       the call id
     * @return the call state response
     */
    public CallStateResponse queryCallStates(String calleeUserId, String callId) {
        CallStateRequest callStateRequest = new CallStateRequest(calleeUserId, callId);
        return workWeChatApiClient.post(WeComEndpoint.PSTNCC_CALL_STATES, callStateRequest, CallStateResponse.class);
    }
}
