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

package cn.felord.payment.wechat.v3.domain.direct.basepay;

import cn.felord.payment.wechat.enumeration.FundAccountType;
import cn.felord.payment.wechat.enumeration.RefundChannel;
import cn.felord.payment.wechat.enumeration.RefundResult;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 申请退款响应
 *
 * @author felord.cn
 * @since 2023/8/17 15:20
 */
@Data
public class RefundResponse {
    /**
     * 微信支付退款单号
     */
    private String refundId;
    /**
     * 商户系统内部的退款单号，商户系统内部唯一，
     * 只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    private String outRefundNo;
    /**
     * 微信支付交易订单号
     */
    private String transactionId;
    /**
     * 原支付交易对应的商户订单号
     */
    private String outTradeNo;
    /**
     * 退款渠道
     */
    private RefundChannel channel;
    /**
     * 退款入账账户，有以下几种情况：
     * <ol>
     *     <li>退回银行卡：{银行名称}{卡类型}{卡尾号}</li>
     *     <li>退回支付用户零钱:支付用户零钱</li>
     *     <li>退还商户:商户基本账户商户结算银行账户</li>
     *     <li>退回支付用户零钱通:支付用户零钱通</li>
     * </ol>
     */
    private String userReceivedAccount;
    /**
     * 退款成功时间
     */
    private OffsetDateTime successTime;
    /**
     * 退款创建时间
     */
    private OffsetDateTime createTime;
    /**
     * 退款状态
     */
    private RefundResult status;
    /**
     * 资金账户
     */
    private FundAccountType fundsAccount;
    /**
     * 金额详细信息
     */
    private RefundAmountDetail amount;
    /**
     * 优惠退款信息
     */
    private List<RefundPromotionDetail> promotionDetail;
}
