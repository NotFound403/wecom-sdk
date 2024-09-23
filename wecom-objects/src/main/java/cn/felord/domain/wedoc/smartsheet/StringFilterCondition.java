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

import cn.felord.enumeration.FilterOperator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * The type String filter condition.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class StringFilterCondition extends AbstractFilterCondition {
    private final StringValue stringValue;

    /**
     * Instantiates a new String filter condition.
     *
     * @param fieldId     the field id
     * @param operator    the operator
     * @param stringValue the value
     */
    @JsonCreator
    StringFilterCondition(@JsonProperty("field_id") String fieldId,
                          @JsonProperty("operator") FilterOperator operator,
                          @JsonProperty("string_value") StringValue stringValue) {
        super(fieldId, operator);
        this.stringValue = stringValue;
    }

    /**
     * Instantiates a new String filter condition.
     *
     * @param fieldId  the field id
     * @param operator the operator
     * @param value    the value
     */
    public StringFilterCondition(String fieldId, FilterOperator operator, Set<String> value) {
        this(fieldId, operator, new StringValue(value));
    }
}
