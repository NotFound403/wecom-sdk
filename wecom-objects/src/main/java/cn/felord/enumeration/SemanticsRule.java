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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Range type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum SemanticsRule {

    /**
     * Phone semantics rule.
     */
    PHONE(1),

    /**
     * Email semantics rule.
     */
    EMAIL(2),
    /**
     * Red envelope semantics rule.
     */
    RED_ENVELOPE(3),
    ;

    private final int rule;

    SemanticsRule(int rule) {
        this.rule = rule;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getRule() {
        return rule;
    }

    /**
     * Deserialize range type.
     *
     * @param rule the rule
     * @return the range type
     */
    @JsonCreator
    public static SemanticsRule deserialize(int rule) {
        return Arrays.stream(SemanticsRule.values())
                .filter(contactType -> contactType.rule == rule)
                .findFirst()
                .orElse(null);
    }

}
