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

package cn.felord.reactive.api;

import cn.felord.domain.authentication.JsTicketResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Js api.
 *
 * @author dax
 * @since 2023 /5/24 17:55
 */
interface JsApi {

    /**
     * 获取企业的jsapi_ticket
     *
     * @return the single
     */
    @GET("get_jsapi_ticket")
    Single<JsTicketResponse> corpJsApiTicket();

    /**
     * 获取应用的jsapi_ticket
     *
     * @return the single
     */
    @GET("ticket/get")
    Single<JsTicketResponse> agentJsApiTicket(@Query("type") String agentConfig);
}
