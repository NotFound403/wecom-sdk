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
 * The enum Checkin exception type.
 *
 * @author dax
 * @since 2024/9/26
 */
public enum CheckinExceptionType {

    /**
     * 迟到
     */
    LATE(1),
    /**
     * 早退
     */
    EARLY(2),
    /**
     * 缺卡
     */
    LACK(3),
    /**
     * 旷工
     */
    ABSENTEEISM(4),
    /**
     * 地点异常
     */
    LOC_ABNORMAL(5),
    /**
     * 设备异常
     */
    DEV_ABNORMAL(6);
    private final int type;

    CheckinExceptionType(int type) {
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
     * Deserialize AttendanceType.
     *
     * @param type the type
     * @return AttendanceType checkin exception type
     */
    @JsonCreator
    public static CheckinExceptionType deserialize(int type) {
        return Arrays.stream(CheckinExceptionType.values())
                .filter(exceptionType -> exceptionType.type == type)
                .findFirst()
                .orElse(null);
    }
}
