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
 * @author dax
 * @since 2023/8/4 14:06
 */
public enum DistanceType {
    /**
     * 当前位置
     */
    CURRENT(0),
    /**
     * 附近100米
     */
    CURRENT100(1),
    /**
     * 附近200米
     */
    CURRENT200(2),
    /**
     * 附近300米
     */
    CURRENT300(3);

    private final int type;

    DistanceType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DistanceType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static DistanceType deserialize(int type) {
        return Arrays.stream(DistanceType.values())
                .filter(distanceType -> distanceType.type == type)
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
