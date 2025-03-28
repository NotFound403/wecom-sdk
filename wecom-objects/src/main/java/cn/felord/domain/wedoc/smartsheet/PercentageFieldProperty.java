/*
 * Copyright (c) 2025. felord.cn
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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 百分数类型的字段属性
 *
 * @author dax
 * @since 2025 /3/28
 */
@ToString
@Getter
public class PercentageFieldProperty {
    private final int decimalPlaces;
    private final boolean useSeparate;

    /**
     * Instantiates a new Percentage field property.
     *
     * @param decimalPlaces the decimal places
     * @param useSeparate   the use separate
     */
    @JsonCreator
    PercentageFieldProperty(@JsonProperty("decimal_places") int decimalPlaces,
                            @JsonProperty("use_separate") boolean useSeparate) {
        this.decimalPlaces = decimalPlaces;
        this.useSeparate = useSeparate;
    }

    /**
     * 使用千位符
     *
     * @param decimalPlaces the decimal places
     * @return the percentage field property
     */
    public PercentageFieldProperty useSeparate(int decimalPlaces) {
        return new PercentageFieldProperty(decimalPlaces, true);
    }

    /**
     * 不使用千位符
     *
     * @param decimalPlaces the decimal places
     * @return the percentage field property
     */
    public PercentageFieldProperty unuseSeparate(int decimalPlaces) {
        return new PercentageFieldProperty(decimalPlaces, false);
    }

}
