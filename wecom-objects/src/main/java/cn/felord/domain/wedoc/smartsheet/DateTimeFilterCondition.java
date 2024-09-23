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

import cn.felord.enumeration.FilterDateTimeType;
import cn.felord.enumeration.FilterOperator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Date time filter condition.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class DateTimeFilterCondition extends AbstractFilterCondition {
    private final DateTimeValue dateTimeValue;

    /**
     * Instantiates a new Date time filter condition.
     *
     * @param fieldId       the field id
     * @param operator      the operator
     * @param dateTimeValue the date time value
     */
    @JsonCreator
    DateTimeFilterCondition(@JsonProperty("field_id") String fieldId,
                            @JsonProperty("operator") FilterOperator operator,
                            @JsonProperty("date_time_value") DateTimeValue dateTimeValue) {
        super(fieldId, operator);
        this.dateTimeValue = dateTimeValue;
    }

    /**
     * Instantiates a new Date time filter condition.
     *
     * @param fieldId  the field id
     * @param operator the operator
     * @param type     the type
     * @param value    the value
     */
    public DateTimeFilterCondition(String fieldId, FilterOperator operator, FilterDateTimeType type, List<String> value) {
        this(fieldId, operator, new DateTimeValue(type, value));
    }

    /**
     * Instantiates a new Date time filter condition.
     *
     * @param fieldId  the field id
     * @param operator the operator
     * @param type     the type
     */
    public DateTimeFilterCondition(String fieldId, FilterOperator operator, FilterDateTimeType type) {
        this(fieldId, operator, new DateTimeValue(type));
    }
}
