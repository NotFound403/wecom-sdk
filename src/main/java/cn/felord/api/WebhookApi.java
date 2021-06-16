package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.domain.webhook.WebhookTextBody;
import cn.felord.enumeration.WeComDomain;
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
     * Instantiates a new Webhook api.
     *
     * @param key the key
     */
    public WebhookApi(String key) {
        super(UriComponentsBuilder.fromHttpUrl(WeComEndpoint.WEBHOOK_SEND.endpoint(WeComDomain.CGI_BIN))
                .queryParam("key", key)
                .build()
                .toUri());
    }

    /**
     * Send text we com response.
     *
     * @param <T>  the type parameter
     * @param body the body
     * @return the we com response
     */
    public <T extends WebhookBody> WeComResponse sendText(T body) {
        return this.getWeComClient().post(this.getUri(), body, WeComResponse.class);
    }
}
