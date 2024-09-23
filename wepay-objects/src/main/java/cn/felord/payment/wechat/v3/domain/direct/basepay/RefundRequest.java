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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 退款请求参数
 *
 * @author felord.cn
 * @since 2024/8/17 14:24
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class RefundRequest {

    /**
     * 微信支付订单号，同{@link RefundRequest#outTradeNo} 二选一
     */
    private final String transactionId;
    /**
     * 商户订单号，同{@link RefundRequest#transactionId} 二选一
     */
    private final String outTradeNo;
    /**
     * 商户退款单号
     */
    private final String outRefundNo;
    /**
     * 退款订单金额信息
     */
    private final RefundAmount amount;
    /**
     * 退款原因
     */
    private String reason;
    /**
     * 退款结果回调url
     */
    private String notifyUrl;
    /**
     * 退款资金来源，若传递此参数则使用对应的资金账户退款，否则默认使用未结算资金退款（仅对老资金流商户适用）。
     * 枚举值：
     * <ul>
     *     <li>AVAILABLE：可用余额账户</li>
     * </ul>
     */
    private String fundsAccount;
    /**
     * 退款订单的商品信息
     */
    private List<RefundGoodsDetail> goodsDetail;


    /**
     * Reason refund request.
     *
     * @param reason the reason
     * @return the refund request
     */
    public RefundRequest reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Notify url refund request.
     *
     * @param notifyUrl the notify url
     * @return the refund request
     */
    public RefundRequest notifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    /**
     * 仅老资金流商户适用
     *
     * @return the refund request
     */
    public RefundRequest fundsAccount() {
        this.fundsAccount = "AVAILABLE";
        return this;
    }

    /**
     * Dis funds account refund request.
     *
     * @return the refund request
     */
    public RefundRequest disFundsAccount() {
        this.fundsAccount = null;
        return this;
    }

    /**
     * Goods detail refund request.
     *
     * @param goodsDetail the goods detail
     * @return the refund request
     */
    public RefundRequest goodsDetail(List<RefundGoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
        return this;
    }

    /**
     * 通过微信支付订单号退款
     *
     * @param transactionId the transaction id
     * @param outRefundNo   the out refund no
     * @param amount        the amount
     * @return the refund request
     */
    public static RefundRequest withTransactionId(String transactionId, String outRefundNo, RefundAmount amount) {
        return new RefundRequest(transactionId, null, outRefundNo, amount);
    }

    /**
     * 通过商户订单号退款
     *
     * @param outTradeNo  the out trade no
     * @param outRefundNo the out refund no
     * @param amount      the amount
     * @return the refund request
     */
    public static RefundRequest withOutTradeNo(String outTradeNo, String outRefundNo, RefundAmount amount) {
        return new RefundRequest(null, outTradeNo, outRefundNo, amount);
    }
}
