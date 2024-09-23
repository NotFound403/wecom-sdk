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

import cn.felord.enumeration.DecimalPlaces;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Progress field property.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class ProgressFieldProperty {
    private final Integer decimalPlaces;


    /**
     * Instantiates a new Progress field property.
     *
     * @param decimalPlaces the decimal places
     */
    @JsonCreator
    ProgressFieldProperty(@JsonProperty("decimal_places") Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;

    }

    /**
     * Of progress field property.
     *
     * @param decimalPlaces the decimal places
     * @return the number field property
     */
    public ProgressFieldProperty of(DecimalPlaces decimalPlaces) {
        return new ProgressFieldProperty(decimalPlaces.getType());
    }
}
