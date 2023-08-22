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

package cn.felord.payment.wechat.v3.api.direct;

import cn.felord.payment.wechat.v3.domain.payscore.PayScoreOrder;
import cn.felord.payment.wechat.v3.domain.payscore.QueryServiceOrderParams;
import cn.felord.payment.wechat.v3.domain.payscore.PayScoreOrderResponse;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 支付分API
 *
 * @author dax
 * @since 2023 /8/21
 */
interface InternalPayScoreApi {


    /**
     * 创建支付分订单API
     *
     * @param order the order
     * @return the response body
     */
    @POST("v3/payscore/serviceorder")
    PayScoreOrderResponse serviceOrder(@Body PayScoreOrder order);

    /**
     * 查询支付分订单API
     *
     * @param params the params
     * @return the response body
     */
    @GET("v3/payscore/serviceorder")
    PayScoreOrder serviceOrder(QueryServiceOrderParams params);

    /**
     * Cancel response body.
     *
     * @param params the params
     * @return the response body
     */
    @POST("v3/payscore/serviceorder/{out_order_no}/cancel")
    ResponseBody cancel(@Body QueryServiceOrderParams params);
}
