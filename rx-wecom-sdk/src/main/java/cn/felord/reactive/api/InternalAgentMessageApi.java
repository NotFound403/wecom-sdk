package cn.felord.reactive.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MsgId;
import cn.felord.domain.message.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 应用消息
 *
 * @author dax
 * @since 2023/6/29 9:06
 */
interface InternalAgentMessageApi {

    /**
     * 发送应用消息
     *
     * @param body the body
     * @return the message response
     * @see MessageBodyBuilders
     */
    @POST("message/send")
    Single<MessageResponse> send(@Body AbstractMessageBody body);

    /**
     * 更新模版卡片消息
     *
     * @param request the request
     * @return the message response
     * @see TemplateReplaceCardBuilders
     */
    @POST("message/update_template_card")
    <R extends AbstractUpdateTemplateCardRequest> Single<MessageResponse> updateTemplateCard(@Body R request);

    /**
     * 撤回应用消息
     *
     * @param request the request
     * @return the we com response
     */
    @POST("message/recall")
    Single<WeComResponse> recall(@Body MsgId request);
}
