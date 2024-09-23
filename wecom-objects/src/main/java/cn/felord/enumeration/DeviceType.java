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
 * 设备类型
 *
 * @author dax
 * @since 2024/10/10
 */
public enum DeviceType {

    /**
     * WINDOWS
     */
    WINDOWS("Windows"),
    /**
     * MAC
     */
    MAC("Mac");

    private final String type;

    DeviceType(String type) {
        this.type = type;
    }

    /**
     * Deserialize device type.
     *
     * @param type the type
     * @return the device type
     */
    @JsonCreator
    public static DeviceType deserialize(String type) {
        return Arrays.stream(DeviceType.values())
                .filter(deviceType -> deviceType.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}
