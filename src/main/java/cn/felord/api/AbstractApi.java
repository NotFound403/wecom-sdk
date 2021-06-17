package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComClient;

/**
 * @author n1
 * @since 2021/6/16 17:36
 */
public abstract class AbstractApi {
    private final WeComClient weComClient;


    public AbstractApi(AgentDetails agentDetails) {
        this.weComClient = new WeComClient(agentDetails);
    }

    public AbstractApi() {
        this.weComClient = new WeComClient();
    }

    public WeComClient weComClient() {
        return weComClient;
    }

}
