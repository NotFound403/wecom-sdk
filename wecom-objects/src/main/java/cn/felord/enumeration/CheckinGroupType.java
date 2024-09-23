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
 * The enum Checkin group type.
 *
 * @author dax
 * @since 2024/9/25
 */
public enum CheckinGroupType {
    /**
     * 固定时间上下班
     */
    REGULARLY(1),
    /**
     * 按班次上下班
     */
    SHIFT(2),
    /**
     * 自由上下班
     */
    FREE(3);

    private final int type;

    CheckinGroupType(int type) {
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
     * Deserialize CheckinGroupType
     *
     * @param type the type
     * @return the checkin data type
     */
    @JsonCreator
    public static CheckinGroupType deserialize(int type) {
        return Arrays.stream(CheckinGroupType.values())
                .filter(checkinGroupType -> checkinGroupType.type == type)
                .findFirst()
                .orElse(null);
    }
}
