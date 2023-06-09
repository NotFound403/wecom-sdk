package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MsgId;
import cn.felord.domain.message.AbstractMessageBody;
import cn.felord.domain.message.AbstractUpdateTemplateCardRequest;
import cn.felord.domain.message.MessageBodyBuilders;
import cn.felord.domain.message.MessageResponse;
import cn.felord.domain.message.TemplateReplaceCardBuilders;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 应用消息
 *
 * @author dax
 * @since 2021 /11/25
 */
public interface AgentMessageApi {

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
    Single<MessageResponse> updateTemplateCard(@Body AbstractUpdateTemplateCardRequest request);

    /**
     * 撤回应用消息
     *
     * @param request the request
     * @return the we com response
     */
    @POST("message/recall")
    Single<WeComResponse> recall(@Body MsgId request);
}
