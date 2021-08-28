package cn.felord.api.externalcontact;

import cn.felord.Agent;
import cn.felord.api.AbstractApi;

/**
 * @author n1
 * @since 2021/8/28 16:31
 */
public class ExternalContactApi extends AbstractApi {

    public ExternalContactApi agent(Agent contactBookAgent) {
        this.withAgent(contactBookAgent);
        return this;
    }
}
