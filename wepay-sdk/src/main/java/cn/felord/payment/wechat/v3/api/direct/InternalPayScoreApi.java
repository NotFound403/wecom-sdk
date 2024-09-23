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

package cn.felord.payment.wechat.v3.api.direct;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.domain.payscore.CancelRequest;
import cn.felord.payment.wechat.v3.domain.payscore.CancelResponse;
import cn.felord.payment.wechat.v3.domain.payscore.ModifyRequest;
import cn.felord.payment.wechat.v3.domain.payscore.PayScoreOrder;
import cn.felord.payment.wechat.v3.domain.payscore.PayScoreOrderResponse;
import cn.felord.payment.wechat.v3.domain.payscore.QueryServiceOrderParams;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 支付分API
 *
 * @author dax
 * @since 2024/8/21
 */
interface InternalPayScoreApi {


    /**
     * 创建支付分订单API
     *
     * @param order the order
     * @return the response body
     * @throws PayException the pay exception
     */
    @POST("v3/payscore/serviceorder")
    PayScoreOrderResponse serviceOrder(@Body PayScoreOrder order) throws PayException;

    /**
     * 查询支付分订单API
     *
     * @param params the params
     * @return the response body
     * @throws PayException the pay exception
     */
    @GET("v3/payscore/serviceorder")
    PayScoreOrder serviceOrder(QueryServiceOrderParams params) throws PayException;

    /**
     * 取消支付分订单API
     * <p>
     * 微信支付分订单创建之后，由于某些原因导致订单不能正常支付时，可使用此接口取消订单。
     * <p>
     * 订单为以下状态时可以取消订单：CREATED（已创单）、DOING（进行中）（包括商户完结支付分订单后，且支付分订单收款状态为待支付USER_PAYING）
     * <p>
     * 注意：
     * <ul>
     *     <li>DOING状态包含了订单用户确认、已完结-待支付（USER_PAYING）的状态，因此这种状态下订单也是可以被取消的，请确认当前操作是否正确，防止误操作将完结后需要支付分收款的单据取消。</li>
     * </ul>
     * 特别注意：
     * <ol>
     *     <li>待支付（USER_PAYING）状态下，当用户正在尝试通过收银台主动支付订单金额时，取消支付分订单API无法调用成功，可等待3min后重试</li>
     *     <li>重入时需保证参数完全一致，包括撤销原因</li>
     * </ol>
     *
     * @param request the request
     * @return the response body
     * @throws PayException the pay exception
     */
    @POST("v3/payscore/serviceorder/{out_order_no}/cancel")
    CancelResponse cancel(@Body CancelRequest request) throws PayException;

    /**
     * 修改订单金额API
     * <p>
     * 完结订单总金额与实际金额不符时，且当服务订单收款状态处于“待支付（USER_PAYING）”时，商户可通过该接口修改订单金额。
     * <p>
     * 注意：
     * <ul>
     *     <li>若此笔订单已收款成功，商户直接使用退款能力，将差价退回用户即可。</li>
     *     <li>修改次数大于等于1，第n次修改后金额小于第n-1次修改后金额。</li>
     *     <li>押金订单的金额不支持修改。</li>
     * </ul>
     * 特别注意：待支付（USER_PAYING）状态下，当用户正在尝试通过收银台主动支付订单金额时，修改订单金额API无法调用成功，可等待3min后重试
     *
     * @param request the request
     * @return the cannel response
     * @throws PayException the pay exception
     */
    @POST("v3/payscore/serviceorder/{out_order_no}/modify")
    CancelResponse modify(@Body ModifyRequest request) throws PayException;
}
