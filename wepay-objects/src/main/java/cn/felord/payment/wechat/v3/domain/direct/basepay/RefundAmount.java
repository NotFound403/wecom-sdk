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

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 退款订单金额信息
 *
 * @author felord.cn
 * @since 1.0.6.RELEASE
 */
@ToString
@Getter
public class RefundAmount {
    /**
     * 原订单金额，币种的最小单位，只能为整数，不能超过原订单支付金额。
     */
    private final Long total;
    /**
     * 符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。
     */
    private final String currency = "CNY";
    /**
     * 退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额。
     */
    private final Long refund;
    /**
     * 退款出资账户及金额
     *
     * @since 1.0.11.RELEASE
     */
    private final List<RefundForm> form;

    /**
     * Instantiates a new Refund amount.
     *
     * @param total  the total
     * @param refund the refund
     */
    public RefundAmount(long total, Long refund) {
        this(total, refund, null);
    }

    /**
     * Instantiates a new Refund amount.
     *
     * @param total  the total
     * @param refund the refund
     * @param form   the form
     */
    public RefundAmount(long total, Long refund, List<RefundForm> form) {
        this.total = total;
        this.refund = refund;
        this.form = form;
    }
}
