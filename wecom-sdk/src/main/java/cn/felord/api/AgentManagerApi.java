package cn.felord.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentSettingRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 应用配置管理.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public interface AgentManagerApi {

    /**
     * 获取应用详情
     * <p>
     * 应用ID要和对应的token一致
     *
     * @param agentId the agent id
     * @return the agent details
     */
    @GET("agent/get")
    Single<AgentDetailsResponse> getAgentDetails(@Query("agentid") String agentId);

    /**
     * 设置应用
     *
     * @param request the request
     * @return WeComResponse
     */
    @POST("agent/set")
    Single<WeComResponse> settings(AgentSettingRequest request);
}
