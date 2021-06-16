package cn.felord.api;

import cn.felord.WeComClient;

/**
 * @author n1
 * @since 2021/6/16 17:36
 */
public abstract class AbstractApi {
    private WeComClient weComClient = new WeComClient();


    public void setWeComClient(WeComClient weComClient) {
        this.weComClient = weComClient;
    }

    public WeComClient getWeComClient() {
        return weComClient;
    }

}
