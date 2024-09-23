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

package cn.felord.domain.wedoc.smartsheet;

import cn.felord.enumeration.AutoNumberRuleType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Auto number rule.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class AutoNumberRule {
    private final String type;
    private final String value;

    /**
     * Instantiates a new Auto number rule.
     *
     * @param type  the type
     * @param value the value
     */
    @JsonCreator
    AutoNumberRule(@JsonProperty("type") String type, @JsonProperty("value") String value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Of auto number rule.
     *
     * @param type  the type
     * @param value the value
     * @return the auto number rule
     */
    public static AutoNumberRule of(AutoNumberRuleType type, String value) {
        return new AutoNumberRule(type.name(), value);
    }
}
