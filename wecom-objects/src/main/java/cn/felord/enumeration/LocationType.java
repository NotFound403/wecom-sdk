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
 * The enum Location type.
 *
 * @author dax
 * @since 2024/8/4 14:07
 */
public enum LocationType {
    /**
     * 省/市/区/街道+详细地址
     */
    PROVINCIAL_ADD(0),
    /**
     * 省/市
     */
    PROVINCIAL_CITY(1),
    /**
     * 省/市/区
     */
    PROVINCIAL_DISTRICT(2),
    /**
     * 省/市/区/街道
     */
    PROVINCIAL_STREET(3),
    /**
     * 自动定位
     */
    AUTO(4);

    private final int type;

    LocationType(int type) {
        this.type = type;
    }

    /**
     * Deserialize LocationType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static LocationType deserialize(int type) {
        return Arrays.stream(LocationType.values())
                .filter(locationType -> locationType.type == type)
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
