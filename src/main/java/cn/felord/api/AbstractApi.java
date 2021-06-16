package cn.felord.api;

import cn.felord.WeComClient;

import java.net.URI;

/**
 * @author n1
 * @since 2021/6/16 17:36
 */
public abstract class AbstractApi {
    private final WeComClient weComClient = new WeComClient();
    private final URI uri;

    public AbstractApi(URI uri) {
        this.uri = uri;
    }

    public WeComClient getWeComClient() {
        return weComClient;
    }

    public URI getUri() {
        return uri;
    }
}
