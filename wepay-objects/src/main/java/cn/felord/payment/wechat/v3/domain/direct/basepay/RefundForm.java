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

/**
 * 退款出资账户及金额
 * <p>
 * 退款需要从指定账户出资时，传递此参数指定出资金额（币种的最小单位，只能为整数）。
 * <p>
 * 同时指定多个账户出资退款的使用场景需要满足以下条件：
 * <ol>
 *  <li>未开通退款支出分离产品功能；</li>
 *  <li>订单属于分账订单，且分账处于待分账或分账中状态。</li>
 * </ol>
 * <p>
 * 参数传递需要满足条件：
 * <ol>
 *   <li>基本账户可用余额出资金额与基本账户不可用余额出资金额之和等于退款金额；</li>
 *   <li>账户类型不能重复。</li>
 * </ol>
 * <p>
 * 上述任一条件不满足将返回错误
 *
 * @author felord.cn
 * @since 1.0.11.RELEASE
 */
@Getter
public class RefundForm {
    /**
     * 出资账户类型
     * <p>
     * {@code AVAILABLE}  可用余额
     * {@code UNAVAILABLE} 不可用余额
     */
    private final String account;
    /**
     * 对应账户出资金额
     */
    private final Long amount;

    /**
     * Instantiates a new Refund form.
     *
     * @param account the account
     * @param amount  the amount
     */
    @JsonCreator
    RefundForm(@JsonProperty("account") String account, @JsonProperty("amount") Long amount) {
        this.account = account;
        this.amount = amount;
    }

    /**
     * 使用可用余额
     *
     * @param amount the amount
     * @return the refund form
     */
    public RefundForm available(long amount) {
        return new RefundForm("AVAILABLE", amount);
    }

    /**
     * 使用不可用余额
     *
     * @param amount the amount
     * @return the refund form
     */
    public RefundForm unavailable(long amount) {
        return new RefundForm("UNAVAILABLE", amount);
    }
}
