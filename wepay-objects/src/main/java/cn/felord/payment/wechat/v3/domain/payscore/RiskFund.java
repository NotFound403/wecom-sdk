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
package cn.felord.payment.wechat.v3.domain.payscore;

import cn.felord.payment.wechat.enumeration.RiskFundType;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

/**
 * 订单风险金信息，必填
 *
 * @author felord.cn
 * @since 1.0.2.RELEASE
 */
@Data
public class RiskFund {

    /**
     * 风险金名称，必填
     */
    private final RiskFundType name;
    /**
     * 风险金额，必填
     * <ol>
     *     <li>数字，必须&gt;0（单位分）。</li>
     *     <li>风险金额&gt;=每个服务ID的风险金额上限。</li>
     *     <li>当商户优惠字段为空时，付费项目总金额≤服务ID的风险金额上限 （未填写金额的付费项目，视为该付费项目金额为0）。</li>
     *     <li>完结金额可大于、小于或等于风险金额。详细可见QA <a target= "_blank" href= "https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/payscore/chapter11_2.shtml#menu1">关于订单风险金额问题</a></li>
     * </ol>
     */
    private final Long amount;
    /**
     * 风险说明，选填
     * <p>
     * 文字，不超过30个字。
     */
    private final String description;


    /**
     * Instantiates a new Risk fund.
     *
     * @param name   the name
     * @param amount the amount
     */
    public RiskFund(RiskFundType name, Long amount) {
        this(name, amount, null);
    }

    /**
     * Instantiates a new Risk fund.
     *
     * @param name        the name
     * @param amount      the amount
     * @param description the description
     */
    @JsonCreator
    public RiskFund(RiskFundType name, Long amount, String description) {
        this.name = name;
        this.amount = amount;
        this.description = description;
    }
}
