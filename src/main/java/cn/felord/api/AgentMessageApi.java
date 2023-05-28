/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.message.AbstractMessageBody;
import cn.felord.domain.message.AbstractUpdateTemplateCardRequest;
import cn.felord.domain.message.MessageResponse;
import cn.felord.domain.message.TemplateReplaceCardBuilders;
import cn.felord.enumeration.WeComEndpoint;

import java.util.Collections;
import java.util.Objects;

/**
 * 应用消息
 *
 * @author dax
 * @since 2021 /11/25
 */
public class AgentMessageApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Message api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    AgentMessageApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 发送应用消息
     *
     * @param <B>  the type parameter
     * @param body the body
     * @return the message response
     * @see cn.felord.domain.message.MessageBodyBuilders
     */
    public <B extends AbstractMessageBody> MessageResponse send(B body) {

        String msgtype = body.getMsgtype();
        if (!Objects.equals("miniprogram_notice", msgtype)) {
            String agentId = workWeChatApiClient.getAgentDetails().getAgentId();
            body.setAgentid(agentId);
        }
        return workWeChatApiClient.post(WeComEndpoint.MESSAGE_SEND, body, MessageResponse.class);
    }

    /**
     * 更新模版卡片消息
     *
     * @param <B>     the type parameter
     * @param request the request
     * @return the message response
     * @see TemplateReplaceCardBuilders
     */
    public <B extends AbstractUpdateTemplateCardRequest> MessageResponse updateTemplateCard(B request) {
        return workWeChatApiClient.post(WeComEndpoint.UPDATE_TEMPLATE_CARD, request, MessageResponse.class);
    }

    /**
     * 撤回应用消息
     *
     * @param msgId the msg id
     * @return the we com response
     */
    public WeComResponse recall(String msgId) {
        return workWeChatApiClient.post(WeComEndpoint.MESSAGE_RECALL, Collections.singletonMap("msgid", msgId), WeComResponse.class);
    }
}
