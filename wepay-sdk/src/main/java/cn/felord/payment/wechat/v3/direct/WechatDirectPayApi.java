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

package cn.felord.payment.wechat.v3.direct;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.domain.basepay.PrepayResponse;
import cn.felord.payment.wechat.v3.domain.basepay.direct.PayRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 普通支付-直连模式.
 *
 * @author dax
 * @since 2023 /8/11
 */
interface WechatDirectPayApi {

    /**
     * 生成预支付交易单
     *
     * @param payType the pay type
     * @param request the request
     * @return the prepay id
     */
    @POST("v3/pay/transactions/{payType}")
    PrepayResponse prePay(@Path("payType") String payType, @Body PayRequest request) throws PayException;

}