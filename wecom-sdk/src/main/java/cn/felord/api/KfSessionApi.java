package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.callcenter.KfAndExternalUser;
import cn.felord.domain.callcenter.KfEventMessageRequest;
import cn.felord.domain.callcenter.KfMessageRequest;
import cn.felord.domain.callcenter.KfSessionResponse;
import cn.felord.domain.callcenter.KfSessionUpdateRequest;
import cn.felord.domain.callcenter.SyncMsgRequest;
import cn.felord.domain.callcenter.SyncMsgResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 会话分配与消息收发
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public interface KfSessionApi {

    /**
     * 获取会话状态
     *
     * @param kfAndExternalUser the kf and external user
     * @return the generic response
     */
    @POST("kf/service_state/get")
    Single<KfSessionResponse> getSessionState(@Body KfAndExternalUser kfAndExternalUser);

    /**
     * 变更会话状态
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/service_state/trans")
    Single<GenericResponse<String>> trans(@Body KfSessionUpdateRequest request);

    /**
     * 读取消息
     *
     * @param request the request
     * @return the sync msg response
     */
    @POST("kf/sync_msg")
    Single<SyncMsgResponse> syncMsg(@Body SyncMsgRequest request);

    /**
     * 发送消息
     * <p>
     * 当微信客户处于“新接入待处理”或“由智能助手接待”状态下，可调用该接口给用户发送消息。
     * 注意仅当微信客户在主动发送消息给客服后的48小时内，企业可发送消息给客户，最多可发送5条消息；若用户继续发送消息，企业可再次下发消息。
     * 支持发送消息类型：文本、图片、语音、视频、文件、图文、小程序、菜单消息、地理位置。
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    @POST("kf/send_msg")
    <R extends KfMessageRequest> Single<GenericResponse<String>> sendMsg(@Body R request);

    /**
     * 发送欢迎语等事件响应消息
     * <p>
     * 当特定的事件回调消息包含code字段，或通过接口变更到特定的会话状态，会返回code字段。
     * 开发者可以此code为凭证，调用该接口给用户发送相应事件场景下的消息，如客服欢迎语、客服提示语和会话结束语等。
     * 除"用户进入会话事件"以外，响应消息仅支持会话处于获取该code的会话状态时发送，如将会话转入待接入池时获得的code仅能在会话状态为”待接入池排队中“时发送。
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    @POST("kf/send_msg_on_event")
    <R extends KfEventMessageRequest> Single<GenericResponse<String>> sendEventMsg(@Body R request);
}
