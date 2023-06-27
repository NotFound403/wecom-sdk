package cn.felord.reactive.api;

import cn.felord.AgentDetails;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import cn.felord.domain.agent.AgentSettingRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * The type Agent manager api.
 *
 * @author xiafang
 * @since 2023 /6/27 11:33
 */
public class AgentManagerApi {
    private final InternalAgentManagerApi internalAgentManagerApi;
    private final AgentDetails agentDetails;

    /**
     * Instantiates a new Agent manager api.
     *
     * @param retrofit     the retrofit
     * @param agentDetails the agent details
     */
    AgentManagerApi(Retrofit retrofit, AgentDetails agentDetails) {
        this.internalAgentManagerApi = retrofit.create(InternalAgentManagerApi.class);
        this.agentDetails = agentDetails;
    }


    /**
     * Gets agent details.
     *
     * @return the agent details
     */
    public Single<AgentDetailsResponse> getAgentDetails() {
        return internalAgentManagerApi.getAgentDetails(agentDetails.getAgentId());
    }

    /**
     * 设置应用
     *
     * @param request the request
     * @return WeComResponse
     */
    public Single<WeComResponse> settings(AgentSettingRequest request) {
        return internalAgentManagerApi.settings(Settings.from(agentDetails.getAgentId(), request));
    }


    /**
     * The type Settings.
     */
    public static class Settings extends AgentSettingRequest {
        private final String agentid;


        /**
         * From settings.
         *
         * @param agentid the agentid
         * @param request the request
         * @return the settings
         */
        static Settings from(String agentid, AgentSettingRequest request) {
            Settings settings = new Settings(agentid);
            settings.setDescription(request.getDescription());
            settings.setHomeUrl(request.getHomeUrl());
            settings.setIsreportenter(request.getIsreportenter());
            settings.setLogoMediaid(request.getLogoMediaid());
            settings.setName(request.getName());
            settings.setRedirectDomain(request.getRedirectDomain());
            settings.setReportLocationFlag(request.getReportLocationFlag());
            return settings;
        }

        private Settings(String agentid) {
            this.agentid = agentid;
        }

        /**
         * Gets agentid.
         *
         * @return the agentid
         */
        public String getAgentid() {
            return agentid;
        }
    }
}
