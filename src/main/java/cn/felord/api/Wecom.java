package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;

/**
 * The type Wecom.
 *
 * @author dax
 * @since 2022 /10/8 9:34
 */
public final class Wecom {
    private final WeComTokenCacheable weComTokenCacheable;

    /**
     * Instantiates a new Wecom.
     *
     * @param weComTokenCacheable the we com token cacheable
     */
    public Wecom(WeComTokenCacheable weComTokenCacheable) {
        this.weComTokenCacheable = weComTokenCacheable;
    }

    /**
     * 自建应用
     *
     * @param agentDetails the agent details
     * @return the work we chat api
     */
    public WorkWeChatApi self(AgentDetails agentDetails) {
        return new WorkWeChatApi(new AccessTokenApi(weComTokenCacheable, agentDetails));
    }
}
