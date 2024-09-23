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
 * 清空的字段标识
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum CheckinClearType {
    /**
     * 清空spe_workdays字段
     */
    SPE_WORKDAYS(1),
    /**
     * 清空spe_offdays字段
     */
    SPE_OFFDAYS(2),
    /**
     * 清空wifimac_infos字段
     */
    WIFIMAC_INFOS(3),
    /**
     * 清空loc_infos字段( wifimac_infos和loc_infos不可同时为空 )
     */
    LOC_INFOS(4);

    private final int type;

    CheckinClearType(int type) {
        this.type = type;
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

    /**
     * Deserialize CheckinClearType
     *
     * @param type the type
     * @return the moment task type
     */
    @JsonCreator
    public static CheckinClearType deserialize(int type) {
        return Arrays.stream(CheckinClearType.values())
                .filter(checkinClearType -> checkinClearType.type == type)
                .findFirst()
                .orElse(null);
    }
}
