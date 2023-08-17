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

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.domain.direct.basepay.*;
import okhttp3.ResponseBody;
import retrofit2.http.*;

/**
 * 普通支付-直连模式.
 *
 * @author dax
 * @since 2023 /8/11
 */
interface InternalBasePayApi {

    /**
     * 生成预支付交易单
     *
     * @param payType   the pay type
     * @param payParams the pay params
     * @return the prepay id
     * @throws PayException the pay exception
     */
    @POST("v3/pay/transactions/{payType}")
    PrepayResponse prePay(@Path("payType") String payType, @Body PayParams payParams) throws PayException;

    /**
     * 微信支付订单号查询API
     *
     * @param transactionId the transaction id
     * @param mchid         the mchid
     * @return the prepay response
     * @throws PayException the pay exception
     */
    @GET("v3/pay/transactions/id/{transactionId}")
    PayDetailResponse queryTransactionById(@Path("transactionId") String transactionId, @Query("mchid") String mchid) throws PayException;

    /**
     * 商户订单号查询API
     *
     * @param outTradeNo the out trade no
     * @param mchid      the mchid
     * @return the prepay response
     * @throws PayException the pay exception
     */
    @GET("v3/pay/transactions/out-trade-no/{outTradeNo}")
    PayDetailResponse queryTransactionByOutTradeNo(@Path("outTradeNo") String outTradeNo, @Query("mchid") String mchid) throws PayException;

    /**
     * 关闭订单API
     *
     * @param outTradeNo the out trade no
     * @param mchId      the mch id
     * @return the response body
     * @throws PayException the pay exception
     */
    @POST("v3/pay/transactions/out-trade-no/{out_trade_no}/close")
    ResponseBody close(@Path("out_trade_no") String outTradeNo, @Body MchId mchId) throws PayException;

    /**
     * 申请退款API
     *
     * @param request@return the refund response
     * @throws PayException the pay exception
     */
    @POST("v3/refund/domestic/refunds")
    RefundResponse refund(@Body RefundRequest request) throws PayException;

    /**
     * 查询退款API
     *
     * @param outRefundNo the out refund no
     * @return the refund response
     * @throws PayException the pay exception
     */
    @GET("v3/refund/domestic/refunds/{out_refund_no}")
    RefundResponse queryRefundInfo(@Path("out_refund_no") String outRefundNo) throws PayException;

}
