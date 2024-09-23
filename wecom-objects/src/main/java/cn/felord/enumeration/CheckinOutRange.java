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
 * 范围外打卡处理方式
 *
 * @author dax
 * @since 2024/9/25
 */
public enum CheckinOutRange {
    /**
     * 范围外异常，默认值
     */
    EXCEPTION(0),
    /**
     * 正常外勤
     */
    NORMAL(2),
    /**
     * 不允许范围外打卡
     */
    NOT_ALLOWED(3);

    private final int type;

    CheckinOutRange(int type) {
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
     * Deserialize CheckinOutRange
     *
     * @param type the type
     * @return the checkin data type
     */
    @JsonCreator
    public static CheckinOutRange deserialize(int type) {
        return Arrays.stream(CheckinOutRange.values())
                .filter(checkinOutRange -> checkinOutRange.type == type)
                .findFirst()
                .orElse(null);
    }
}
