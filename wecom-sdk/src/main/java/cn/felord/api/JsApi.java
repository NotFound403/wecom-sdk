/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.authentication.JsTicketResponse;
import cn.felord.domain.jssdk.LaunchCodeRequest;
import cn.felord.domain.jssdk.LaunchCodeResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * jsapi ticket.
 *
 * @author dax
 * @since 2024/5/24 17:55
 */
interface JsApi {

    /**
     * 获取企业的jsapi_ticket
     *
     * @return the single
     * @throws WeComException the weComException
     */
    @GET("get_jsapi_ticket")
    JsTicketResponse corpJsApiTicket() throws WeComException;

    /**
     * 获取应用的jsapi_ticket
     *
     * @param agentConfig the agent config
     * @return the single
     * @throws WeComException the weComException
     */
    @GET("ticket/get")
    JsTicketResponse agentJsApiTicket(@Query("type") String agentConfig) throws WeComException;

    /**
     * 获取launch_code
     *
     * @param request the request
     * @return the js ticket response
     * @throws WeComException the weComException
     */
    @POST("get_launch_code")
    LaunchCodeResponse getLaunchCode(@Body LaunchCodeRequest request) throws WeComException;
}
