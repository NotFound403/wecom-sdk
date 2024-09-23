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
 * The type Number filter condition.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class NumberFilterCondition extends AbstractFilterCondition {
    private final NumberValue numberValue;

    /**
     * Instantiates a new Number filter condition.
     *
     * @param fieldId     the field id
     * @param operator    the operator
     * @param numberValue the number value
     */
    @JsonCreator
    NumberFilterCondition(@JsonProperty("field_id") String fieldId,
                          @JsonProperty("operator") FilterOperator operator,
                          @JsonProperty("number_value") NumberValue numberValue) {
        super(fieldId, operator);
        this.numberValue = numberValue;
    }

    /**
     * Instantiates a new Number filter condition.
     *
     * @param fieldId  the field id
     * @param operator the operator
     * @param value    the value
     */
    public NumberFilterCondition(String fieldId, FilterOperator operator, Set<Double> value) {
        this(fieldId, operator, new NumberValue(value));
    }
}
