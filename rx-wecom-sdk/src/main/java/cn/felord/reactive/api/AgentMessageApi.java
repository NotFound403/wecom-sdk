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

import cn.felord.AgentDetails;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MsgId;
import cn.felord.domain.message.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.http.Body;

import java.util.Objects;

/**
 * 应用消息
 *
 * @author dax
 * @since 2021 /11/25
 */
public class AgentMessageApi {
    private final InternalAgentMessageApi internalAgentMessageApi;
    private final AgentDetails agentDetails;

    /**
     * Instantiates a new Agent message api.
     *
     * @param retrofit     the retrofit
     * @param agentDetails the agent details
     */
    AgentMessageApi(Retrofit retrofit, AgentDetails agentDetails) {
        this.internalAgentMessageApi = retrofit.create(InternalAgentMessageApi.class);
        this.agentDetails = agentDetails;
    }

    /**
     * 发送应用消息
     *
     * @param <B>  the type parameter
     * @param body the body
     * @return the message response
     * @see MessageBodyBuilders
     */
    public <B extends AbstractMessageBody> Single<MessageResponse> send(B body) {
        String msgtype = body.getMsgtype();
        if (!Objects.equals("miniprogram_notice", msgtype)) {
            String agentId = this.agentDetails.getAgentId();
            body.setAgentid(agentId);
        }
        return internalAgentMessageApi.send(body);
    }

    /**
     * 更新模版卡片消息
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the message response
     * @see TemplateReplaceCardBuilders
     */
    public <R extends AbstractUpdateTemplateCardRequest> Single<MessageResponse> updateTemplateCard(R request) {
        return internalAgentMessageApi.updateTemplateCard(request);
    }

    /**
     * 撤回应用消息
     *
     * @param request the request
     * @return the we com response
     */
    public Single<WeComResponse> recall(@Body MsgId request) {
        return internalAgentMessageApi.recall(request);
    }
}
