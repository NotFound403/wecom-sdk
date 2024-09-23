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

package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Chain rule.
 *
 * @author dax
 * @since 2024/10/13
 */
@ToString
@Getter
public class ChainRule {
    private final Integer ruleId;
    private final String chainId;

    /**
     * Instantiates a new Chain rule.
     *
     * @param ruleId  the rule id
     * @param chainId the chain id
     */
    ChainRule(Integer ruleId, String chainId) {
        this.ruleId = ruleId;
        this.chainId = chainId;
    }

    /**
     * From chain rule.
     *
     * @param ruleId  the rule id
     * @param chainId the chain id
     * @return the chain rule
     */
    public static ChainRule from(int ruleId, String chainId) {
        return new ChainRule(ruleId, chainId);
    }

}
