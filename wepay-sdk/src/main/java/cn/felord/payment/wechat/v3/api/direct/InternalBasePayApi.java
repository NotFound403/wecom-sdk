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
import cn.felord.payment.wechat.enumeration.FundFlowAccountType;
import cn.felord.payment.wechat.enumeration.TarType;
import cn.felord.payment.wechat.enumeration.TradeBillType;
import cn.felord.payment.wechat.v3.domain.direct.basepay.BillUrlResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.MchId;
import cn.felord.payment.wechat.v3.domain.direct.basepay.PayDetailResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.PayParams;
import cn.felord.payment.wechat.v3.domain.direct.basepay.PrepayResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.RefundRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.RefundResponse;
import cn.felord.retrofit.VoidResponse;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

import java.time.LocalDate;

/**
 * 普通支付-直连模式.
 *
 * @author dax
 * @since 2024/8/11
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
    @GET("v3/pay/transactions/id/{transaction_id}")
    PayDetailResponse queryTransactionById(@Path("transaction_id") String transactionId, @Query("mchid") String mchid) throws PayException;

    /**
     * 商户订单号查询API
     *
     * @param outTradeNo the out trade no
     * @param mchid      the mchid
     * @return the prepay response
     * @throws PayException the pay exception
     */
    @GET("v3/pay/transactions/out-trade-no/{out_trade_no}")
    PayDetailResponse queryTransactionByOutTradeNo(@Path("out_trade_no") String outTradeNo, @Query("mchid") String mchid) throws PayException;

    /**
     * 关闭订单API
     *
     * @param outTradeNo the out trade no
     * @param mchId      the mch id
     * @return the response body
     * @throws PayException the pay exception
     */
    @POST("v3/pay/transactions/out-trade-no/{out_trade_no}/close")
    VoidResponse close(@Path("out_trade_no") String outTradeNo, @Body MchId mchId) throws PayException;

    /**
     * 申请退款API
     *
     * @param request the request
     * @return the refund response
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

    /**
     * 申请交易账单API
     *
     * @param billDate the bill date
     * @param billType the bill type
     * @param tarType  the tar type
     * @return the bill url response
     * @throws PayException the pay exception
     */
    @GET("v3/bill/tradebill")
    BillUrlResponse downloadTradeBill(@Query("bill_date") LocalDate billDate,
                                      @Query("bill_type") TradeBillType billType,
                                      @Query("tar_type") TarType tarType) throws PayException;

    /**
     * 申请资金账单API
     *
     * @param billDate    the bill date
     * @param accountType the account type
     * @param tarType     the tar type
     * @return the bill url response
     * @throws PayException the pay exception
     */
    @GET("v3/bill/fundflowbill")
    BillUrlResponse downloadFundFlowBill(@Query("bill_date") LocalDate billDate,
                                         @Query("account_type") FundFlowAccountType accountType,
                                         @Query("tar_type") TarType tarType) throws PayException;

    /**
     * 通过链接下载文件
     *
     * @param downloadUrl the download url
     * @return the response body
     * @throws PayException the pay exception
     */
    @GET
    ResponseBody download(@Url String downloadUrl) throws PayException;
}
