package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.message.AbstractMessageBody;
import cn.felord.domain.message.AbstractUpdateTemplateCardRequest;
import cn.felord.domain.message.MessageResponse;
import cn.felord.domain.message.TemplateReplaceCardBuilders;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
        String endpoint = WeComEndpoint.MESSAGE_SEND.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, body, MessageResponse.class);
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
        String endpoint = WeComEndpoint.UPDATE_TEMPLATE_CARD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, MessageResponse.class);
    }

    /**
     * 撤回应用消息
     *
     * @param msgId the msg id
     * @return the we com response
     */
    public WeComResponse recall(String msgId) {
        String endpoint = WeComEndpoint.MESSAGE_RECALL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("msgid", msgId), WeComResponse.class);
    }
}
