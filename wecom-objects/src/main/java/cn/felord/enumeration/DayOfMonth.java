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
 * The enum Day of month.
 *
 * @author dax
 * @since 2024/10/5
 */
public enum DayOfMonth {
    /**
     * Day 1 day of month.
     */
    DAY_1(1),
    /**
     * Day 2 day of month.
     */
    DAY_2(2),
    /**
     * Day 3 day of month.
     */
    DAY_3(3),
    /**
     * Day 4 day of month.
     */
    DAY_4(4),
    /**
     * Day 5 day of month.
     */
    DAY_5(5),
    /**
     * Day 6 day of month.
     */
    DAY_6(6),
    /**
     * Day 7 day of month.
     */
    DAY_7(7),
    /**
     * Day 8 day of month.
     */
    DAY_8(8),
    /**
     * Day 9 day of month.
     */
    DAY_9(9),
    /**
     * Day 10 day of month.
     */
    DAY_10(10),
    /**
     * Day 11 day of month.
     */
    DAY_11(11),
    /**
     * Day 12 day of month.
     */
    DAY_12(12),
    /**
     * Day 13 day of month.
     */
    DAY_13(13),
    /**
     * Day 14 day of month.
     */
    DAY_14(14),
    /**
     * Day 15 day of month.
     */
    DAY_15(15),
    /**
     * Day 16 day of month.
     */
    DAY_16(16),
    /**
     * Day 17 day of month.
     */
    DAY_17(17),
    /**
     * Day 18 day of month.
     */
    DAY_18(18),
    /**
     * Day 19 day of month.
     */
    DAY_19(19),
    /**
     * Day 20 day of month.
     */
    DAY_20(20),
    /**
     * Day 21 day of month.
     */
    DAY_21(21),
    /**
     * Day 22 day of month.
     */
    DAY_22(22),
    /**
     * Day 23 day of month.
     */
    DAY_23(23),
    /**
     * Day 24 day of month.
     */
    DAY_24(24),
    /**
     * Day 25 day of month.
     */
    DAY_25(25),
    /**
     * Day 26 day of month.
     */
    DAY_26(26),
    /**
     * Day 27 day of month.
     */
    DAY_27(27),
    /**
     * Day 28 day of month.
     */
    DAY_28(28),
    /**
     * Day 29 day of month.
     */
    DAY_29(29),
    /**
     * Day 30 day of month.
     */
    DAY_30(30),
    /**
     * Day 31 day of month.
     */
    DAY_31(31);

    private final int day;

    DayOfMonth(int day) {
        this.day = day;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    @JsonValue
    public int getDay() {
        return day;
    }

    /**
     * Deserialize day of month.
     *
     * @param day the day
     * @return the day of month
     */
    @JsonCreator
    public static DayOfMonth deserialize(int day) {
        return Arrays.stream(DayOfMonth.values())
                .filter(dayOfMonth -> dayOfMonth.day == day)
                .findFirst()
                .orElse(null);
    }
}
