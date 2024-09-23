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
package cn.felord.domain.corpay.miniapppay.callback;

import cn.felord.domain.corpay.miniapppay.OrderAmount;
import cn.felord.enumeration.CallbackRefundStatus;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * 微信支付退款结果通知解密
 *
 * @author felord.cn
 * @since 1.0.6.RELEASE
 */
@Data
public class RefundCallbackData {
    /**
     * 直连商户号
     */
    private String mchid;
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 微信订单号
     */
    private String transactionId;
    /**
     * 商户退款单号
     */
    private String outRefundNo;
    /**
     * 微信退款单号
     */
    private String refundId;
    /**
     * 退款状态
     */
    private CallbackRefundStatus refundStatus;
    /**
     * 退款成功时间
     */
    private OffsetDateTime successTime;
    /**
     * 退款入账账户
     */
    private String userReceivedAccount;
    /**
     * 金额信息
     */
    private OrderAmount amount;

}
