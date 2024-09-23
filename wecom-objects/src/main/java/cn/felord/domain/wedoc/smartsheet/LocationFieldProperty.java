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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Location field property.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class LocationFieldProperty {
    private final String inputType;

    /**
     * Instantiates a new Location field property.
     *
     * @param inputType the input type
     */
    @JsonCreator
    LocationFieldProperty(@JsonProperty("input_type") String inputType) {
        this.inputType = inputType;
    }

    /**
     * 手动输入
     *
     * @return the location field property
     */
    public static LocationFieldProperty manual() {
        return new LocationFieldProperty("LOCATION_INPUT_TYPE_MANUAL");
    }

    /**
     * 自动定位
     *
     * @return the location field property
     */
    public static LocationFieldProperty auto() {
        return new LocationFieldProperty("LOCATION_INPUT_TYPE_AUTO");
    }
}
