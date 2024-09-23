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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

/**
 * 数字组件
 *
 * @author dax
 * @since 2024/5/26
 */
@ToString
@Getter
public class NumberValue implements ContentDataValue {
    private final String newNumber;

    /**
     * Instantiates a new Number value.
     *
     * @param newNumber the new number
     */
    @JsonCreator
    NumberValue(@JsonProperty("new_number") String newNumber) {
        this.newNumber = newNumber;
    }

    public static NumberValue from(Integer newNumber) {
        return new NumberValue(Optional.ofNullable(newNumber)
                .map(String::valueOf)
                .orElse(null));
    }

    /**
     * From number value.
     *
     * @param newNumber the new number
     * @return the number value
     */
    public static NumberValue from(Double newNumber) {
        return new NumberValue(Optional.ofNullable(newNumber)
                .map(String::valueOf)
                .orElse(null));
    }

}
