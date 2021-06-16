package cn.felord.api;

import cn.felord.WeComClient;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author n1
 * @since 2021/6/16 17:36
 */
public abstract class AbstractApi {
    private WeComClient weComClient = new WeComClient();
    private final UriComponentsBuilder uriComponentsBuilder;

    public AbstractApi(UriComponentsBuilder uriComponentsBuilder) {
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    public void setWeComClient(WeComClient weComClient) {
        this.weComClient = weComClient;
    }

    public WeComClient getWeComClient() {
        return weComClient;
    }

    public UriComponentsBuilder getUriComponentsBuilder() {
        return uriComponentsBuilder;
    }
}
