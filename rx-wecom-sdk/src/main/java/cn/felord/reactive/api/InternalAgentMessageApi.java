/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
 * @since 2024/6/29 9:06
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
