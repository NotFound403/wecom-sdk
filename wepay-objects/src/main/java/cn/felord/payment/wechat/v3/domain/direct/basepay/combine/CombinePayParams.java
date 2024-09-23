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

import cn.felord.payment.wechat.v3.domain.direct.basepay.Payer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 合单支付 APP支付、H5支付、JSAPI支付、小程序支付、Native支付参数.
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class CombinePayParams {

    /**
     * 合单商户appid，必填
     */
    private final String combineAppid;
    /**
     * 合单商户号，必填
     */
    private final String combineMchid;
    /**
     * 合单商户订单号，必填，商户侧需要保证同一商户下唯一
     */
    private final String combineOutTradeNo;
    /**
     * 合单支付者信息，选填
     */
    private final Payer combinePayerInfo;
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
     * 合单支付场景信息描述，选填
     */
    private final CombineSceneInfo sceneInfo;
    /**
     * 交易起始时间，选填
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final OffsetDateTime timeStart;
    /**
     * 交易结束时间，选填
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final OffsetDateTime timeExpire;

}
