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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 退款金额详细信息
 *
 * @author felord.cn
 * @since 2024/8/17 15:45
 */
@ToString
@Setter
@Getter
public class RefundAmountDetail extends RefundAmount {
    /**
     * 用户支付金额
     */
    private Long payerTotal;
    /**
     * 退款给用户的金额，不包含所有优惠券金额
     */
    private Long payerRefund;
    /**
     * 去掉非充值代金券退款金额后的退款金额，单位为分，退款金额等于（申请退款金额减去非充值代金券退款金额），退款金额小于等于申请退款金额
     */
    private Long settlementRefund;
    /**
     * 应结订单金额等于（订单金额减去免充值代金券金额），应结订单金额小于等于订单金额，单位为分
     */
    private Long settlementTotal;
    /**
     * 优惠退款金额小于等于退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠，单位为分
     */
    private Long discountRefund;
    /**
     * 手续费退款金额，单位为分。
     */
    private Long refundFee;


    /**
     * Instantiates a new Refund amount detail.
     *
     * @param total  the total
     * @param refund the refund
     * @param form   the form
     */
    @JsonCreator
    public RefundAmountDetail(@JsonProperty("total") Long total,
                              @JsonProperty("refund") Long refund,
                              @JsonProperty("form") List<RefundForm> form) {
        super(total, refund, form);
    }
}
