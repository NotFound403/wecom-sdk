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

package cn.felord.payment.wechat.v3.domain.direct.basepay.combine;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 直连模式-合单H5下单请求参数
 *
 * @author felord.cn
 * @since 2024/8/17 11:23
 */
@RequiredArgsConstructor
public class CombineH5PayRequest {

    /**
     * 合单商户订单号，必填，商户侧需要保证同一商户下唯一
     */
    private final String combineOutTradeNo;
    /**
     * 子单信息，必填
     */
    private final List<SubOrder> subOrders;
    /**
     * 通知地址，必填，接收微信支付异步通知回调地址，通知url必须为直接可访问的URL，不能携带参数。
     * <p>
     * <strong>合单支付需要独立的通知地址。</strong>
     */
    private final String notifyUrl;
    /**
     * 合单支付场景信息描述，必填
     */
    private final CombineH5SceneInfo sceneInfo;
    /**
     * 交易起始时间，选填
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime timeStart;
    /**
     * 交易结束时间，选填
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime timeExpire;

    /**
     * Time start combine h5 pay request.
     *
     * @param timeStart the time start
     * @return the combine h5 pay request
     */
    public CombineH5PayRequest timeStart(OffsetDateTime timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    /**
     * Time expire combine h5 pay request.
     *
     * @param timeExpire the time expire
     * @return the combine h5 pay request
     */
    public CombineH5PayRequest timeExpire(OffsetDateTime timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }

    /**
     * To params combine pay params.
     *
     * @param combineAppid the combine appid
     * @param combineMchid the combine mchid
     * @return the combine pay params
     */
    public CombinePayParams toPayParams(String combineAppid, String combineMchid) {
        return new CombinePayParams(combineAppid, combineMchid,
                combineOutTradeNo, null,
                subOrders, notifyUrl,
                sceneInfo, timeStart, timeExpire);
    }

}
