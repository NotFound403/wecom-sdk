package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * The type Webhook api.
 *
 * @author n1
 * @since 2021 /6/16 17:35
 */
public class WebhookApi extends AbstractApi {


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
        return this.post(uri, body, WeComResponse.class);
    }
}
