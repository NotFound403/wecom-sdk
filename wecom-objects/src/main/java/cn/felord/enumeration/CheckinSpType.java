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
 * The enum Checkin sp type.
 *
 * @author dax
 * @since 2024/9/26
 */
public enum CheckinSpType {

    /**
     * 请假
     */
    LEAVE(1),
    /**
     * 补卡
     */
    APPLY_OFF(2),
    /**
     * 出差
     */
    BUSINESS_TRIP(3),
    /**
     * 外出
     */
    GOING_OUT(4),
    /**
     * 外勤
     */
    OUTSIDE(100);
    private final int type;

    CheckinSpType(int type) {
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
     * Deserialize CheckinSpType.
     *
     * @param type the type
     * @return AttendanceType checkin sp type
     */
    @JsonCreator
    public static CheckinSpType deserialize(int type) {
        return Arrays.stream(CheckinSpType.values()).filter(checkinSpType -> checkinSpType.type == type).findFirst().orElse(null);
    }
}
