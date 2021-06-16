package cn.felord.api;

import cn.felord.WeComClient;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
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
    private final UriComponentsBuilder componentsBuilder;

    /**
     * Instantiates a new Webhook api.
     */
    public WebhookApi() {
        setWeComClient(new WeComClient(false));
        this.componentsBuilder = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.WEBHOOK_SEND.endpoint(WeComDomain.CGI_BIN));
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
        URI uri = this.componentsBuilder.queryParam("key", key)
                .build()
                .toUri();
        return this.getWeComClient().post(uri, body, WeComResponse.class);
    }
}
