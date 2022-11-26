package cn.felord.api;

import cn.felord.domain.message.AbstractMessageBody;
import cn.felord.domain.message.MessageResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

/**
 * The type Message api.
 *
 * @author dax
 * @since 2022 /11/25
 */
public class MessageApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Message api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    MessageApi(WorkWeChatApiClient workWeChatApiClient) {
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
        if (!Objects.equals("miniprogram_notice",msgtype)){
            String agentId = workWeChatApiClient.getAgentDetails().getAgentId();
            body.setAgentid(agentId);
        }
        String endpoint = WeComEndpoint.MESSAGE_SEND.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, body, MessageResponse.class);
    }
}
