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

import cn.felord.enumeration.AutoNumberFieldType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Auto number field property.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class AutoNumberFieldProperty {
    private final String type;
    private final List<AutoNumberRule> rules;
    private final Boolean reformatExistingRecord;

    /**
     * Instantiates a new Auto number field property.
     *
     * @param type                   the type
     * @param rules                  the rules
     * @param reformatExistingRecord the reformat existing record
     */
    @JsonCreator
    AutoNumberFieldProperty(@JsonProperty("type") String type,
                            @JsonProperty("rules") List<AutoNumberRule> rules,
                            @JsonProperty("reformat_existing_record") Boolean reformatExistingRecord) {
        this.type = type;
        this.rules = rules;
        this.reformatExistingRecord = reformatExistingRecord;
    }

    /**
     * Of auto number field property.
     *
     * @param type                   the type
     * @param rules                  the rules
     * @param reformatExistingRecord the reformat existing record
     * @return the auto number field property
     */
    public static AutoNumberFieldProperty of(AutoNumberFieldType type, List<AutoNumberRule> rules, boolean reformatExistingRecord) {
        return new AutoNumberFieldProperty(type.name(), rules, reformatExistingRecord);
    }
}
