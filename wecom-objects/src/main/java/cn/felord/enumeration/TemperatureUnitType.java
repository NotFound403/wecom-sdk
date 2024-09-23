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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 温度单位
 *
 * @author dax
 * @since 2024/8/4 14:28
 */
public enum TemperatureUnitType {
    /**
     * 摄氏度
     */
    CELSIUS(0),
    /**
     * 华氏度
     */
    FAHRENHEIT(1);

    private final int type;

    TemperatureUnitType(int type) {
        this.type = type;
    }

    /**
     * Deserialize TemperatureUnitType
     *
     * @param type the type
     * @return the TemperatureUnitType
     */
    @JsonCreator
    public static TemperatureUnitType deserialize(int type) {
        return Arrays.stream(TemperatureUnitType.values())
                .filter(temperatureUnitType -> temperatureUnitType.type == type)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

}
