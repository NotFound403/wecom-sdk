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

package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 支付后营销规则结构体
 */
@Data
public class PayGiftRuleInfo {
    /**
     * 营销规则类型
     */
    private final String type = "RULE_TYPE_PAY_MEMBER_CARD";
    /**
     * 营销规则结构体
     */
    private final RuleBaseInfo baseInfo;
    /**
     * 支付即会员结构体
     */
    private final MemberRule memberRule;

    /**
     * Instantiates a new Pay gift rule info.
     *
     * @param baseInfo the base info
     */
    public PayGiftRuleInfo(RuleBaseInfo baseInfo) {
        this(baseInfo, null);
    }

    /**
     * Instantiates a new Pay gift rule info.
     *
     * @param baseInfo   the base info
     * @param memberRule the member rule
     */
    public PayGiftRuleInfo(RuleBaseInfo baseInfo, MemberRule memberRule) {
        this.baseInfo = baseInfo;
        this.memberRule = memberRule;
    }
}
