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
 * The enum Week day.
 *
 * @author dax
 * @since 2024/8/18 17:36
 */
public enum WeekDay {
    /**
     * 周日
     */
    SUNDAY(0),
    /**
     * 周一
     */
    MONDAY(1),
    /**
     * 周二
     */
    TUESDAY(2),
    /**
     * 周三
     */
    WEDNESDAY(3),
    /**
     * 周四
     */
    THURSDAY(4),
    /**
     * 周五
     */
    FRIDAY(5),
    /**
     * 周六
     */
    SATURDAY(6);

    private final int day;

    WeekDay(int day) {
        this.day = day;
    }

    /**
     * Deserialize weekDay
     *
     * @param day the day
     * @return the checkin data type
     */
    @JsonCreator
    public static WeekDay deserialize(int day) {
        return Arrays.stream(WeekDay.values())
                .filter(weekDay -> weekDay.day == day)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int day() {
        return day;
    }
}
