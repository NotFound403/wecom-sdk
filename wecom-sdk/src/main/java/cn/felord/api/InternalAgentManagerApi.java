/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.agent.AgentDetailsResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 应用配置管理.
 *
 * @author felord.cn
 * @since 1.0.0
 */
interface InternalAgentManagerApi {

    /**
     * 获取应用详情
     * <p>
     * 应用ID要和对应的token一致
     *
     * @param agentId the agent id
     * @return the agent details
     * @throws WeComException the we com exception
     */
    @GET("agent/get")
    AgentDetailsResponse getAgentDetails(@Query("agentid") String agentId) throws WeComException;

    /**
     * 设置应用
     *
     * @param settings the settings
     * @return WeComResponse
     * @throws WeComException the we com exception
     */
    @POST("agent/set")
    WeComResponse settings(@Body AgentManagerApi.Settings settings) throws WeComException;
}
