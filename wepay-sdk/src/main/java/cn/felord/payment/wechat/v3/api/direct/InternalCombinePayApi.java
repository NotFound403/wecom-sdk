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
import cn.felord.payment.wechat.v3.domain.direct.basepay.PrepayResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombinePayCloseParams;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombinePayDetailResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombinePayParams;
import cn.felord.retrofit.VoidResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 普通支付-直连模式-合单支付.
 *
 * @author dax
 * @since 2024/8/11
 */
interface InternalCombinePayApi {

    /**
     * 生成预支付交易单
     *
     * @param payType          the pay type
     * @param combinePayParams the combine pay params
     * @return the prepay id
     * @throws PayException the pay exception
     */
    @POST("v3/pay/combine-transactions/{payType}")
    PrepayResponse prePay(@Path("payType") String payType, @Body CombinePayParams combinePayParams) throws PayException;

    /**
     * 合单查询订单API
     *
     * @param combineOutTradeNo the combine out trade no
     * @return the combine pay detail response
     * @throws PayException the pay exception
     */
    @GET("v3/combine-transactions/out-trade-no/{combine_out_trade_no}")
    CombinePayDetailResponse queryTransactionByOutTradeNo(@Path("combine_out_trade_no") String combineOutTradeNo) throws PayException;

    /**
     * 合单关闭订单API
     *
     * @param combineOutTradeNo     the combine out trade no
     * @param combinePayCloseParams the combine pay close params
     * @return the response body
     * @throws PayException the pay exception
     */
    @POST("v3/combine-transactions/out-trade-no/{combine_out_trade_no}/close")
    VoidResponse close(@Path("combine_out_trade_no") String combineOutTradeNo, @Body CombinePayCloseParams combinePayCloseParams) throws PayException;

}
