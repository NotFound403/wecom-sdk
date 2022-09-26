package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;

/**
 * 微信客服
 *
 * @author dax
 * @since 2021 /7/26 13:42
 */
public class CallCenterManager {
    private final WeComCacheable cacheable;

    /**
     * Instantiates a new Call center manager.
     *
     * @param cacheable the cacheable
     */
    CallCenterManager(WeComCacheable cacheable) {
        this.cacheable = cacheable;
    }

    /**
     * 客服账号管理
     *
     * @param agent the agent
     * @return the service account manager api
     */
    public KfAccountApi kfAccountApi(AgentDetails agent) {
        return new KfAccountApi(cacheable).agent(agent);
    }

    /**
     * 接待人员管理
     *
     * @param agent the agent
     * @return the kf servicer api
     */
    public KfServicerApi kfServicerApi(AgentDetails agent) {
        return new KfServicerApi(cacheable).agent(agent);
    }

}
