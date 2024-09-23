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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Date time value.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class DateTimeValue {
    private final FilterDateTimeType type;
    private final List<String> value;

    /**
     * Instantiates a new Date time value.
     *
     * @param type  the type
     * @param value the value
     */
    @JsonCreator
    public DateTimeValue(@JsonProperty("type") FilterDateTimeType type,
                         @JsonProperty("value") List<String> value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Instantiates a new Date time value.
     *
     * @param type the type
     */
    public DateTimeValue(FilterDateTimeType type) {
        this(type, null);
    }
}
