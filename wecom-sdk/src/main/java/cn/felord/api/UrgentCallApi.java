package cn.felord.api;

import cn.felord.domain.urgentcall.CallResponse;
import cn.felord.domain.urgentcall.CallStateRequest;
import cn.felord.domain.urgentcall.CallStateResponse;
import cn.felord.domain.urgentcall.CalleeUsers;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 紧急通知API
 * <p>
 * 【医疗行业】的企业，可通过语音电话提醒员工查看应用推送的重要消息，以便尽快处理紧急事件
 *
 * @author dax
 * @since 2023 /5/31 12:44
 */
public interface UrgentCallApi {

    /**
     * 发起语音电话
     * <p>
     * 通过此接口发起语音电话，提醒员工查看应用推送的重要消息
     *
     * @param callUsers the call users
     * @return the call response
     */
    @POST("pstncc/call")
    Single<CallResponse> call(@Body CalleeUsers callUsers);

    /**
     * 获取接听状态
     *
     * @param request the request
     * @return the call state response
     */
    @POST("pstncc/getstates")
    Single<CallStateResponse> queryCallStates(@Body CallStateRequest request);
}
