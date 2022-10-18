package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 群机器人
 *
 * @author n1
 * @since 2021 /6/16 19:35
 */
public class WebhookApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Webhook api.
     */
    WebhookApi() {
        this.workWeChatApiClient = new WorkWeChatApiClient();
    }

    /**
     * Send text we com response.
     *
     * @param <T>  the type parameter
     * @param key  the key
     * @param body the body
     * @return the we com response
     */
    public <T extends WebhookBody> WeComResponse send(String key, T body) {
        String endpoint = WeComEndpoint.WEBHOOK_SEND.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("key", key)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, body, WeComResponse.class);
    }
}
