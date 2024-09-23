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

package cn.felord.domain.approval;

import cn.felord.enumeration.AttendanceType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 假勤组件-出差/外出/加班组件
 *
 * @author dax
 * @since 2024/5/27
 */
@ToString
@Getter
public class AttendanceValue implements ContentDataValue {
    private final Wrapper attendance;


    /**
     * Instantiates a new Attendance value.
     *
     * @param attendance the attendance
     */
    @JsonCreator
    AttendanceValue(@JsonProperty("attendance") Wrapper attendance) {
        this.attendance = attendance;
    }


    /**
     * Instantiates a new Attendance value.
     *
     * @param type      the type
     * @param dateRange the date range
     */
    public AttendanceValue(AttendanceType type, DateRangeWrapper dateRange) {
        this.attendance = new Wrapper(type, dateRange);
    }


    /**
     * 请假
     *
     * @param dateRange the date range
     * @return the attendance value
     */
    public static AttendanceValue leave(DateRangeWrapper dateRange) {
        return new AttendanceValue(AttendanceType.LEAVE, dateRange);
    }

    /**
     * 出差
     *
     * @param dateRange the date range
     * @return the attendance value
     */
    public static AttendanceValue trip(DateRangeWrapper dateRange) {
        return new AttendanceValue(AttendanceType.BUSINESS_TRIP, dateRange);
    }

    /**
     * 外出
     *
     * @param dateRange the date range
     * @return the attendance value
     */
    public static AttendanceValue goingOut(DateRangeWrapper dateRange) {
        return new AttendanceValue(AttendanceType.GOING_OUT, dateRange);
    }

    /**
     * 加班
     *
     * @param dateRange the date range
     * @return the attendance value
     */
    public static AttendanceValue overtime(DateRangeWrapper dateRange) {
        return new AttendanceValue(AttendanceType.OVERTIME_WORK, dateRange);
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final AttendanceType type;
        private final DateRangeWrapper dateRange;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type      the type
         * @param dateRange the date range
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") AttendanceType type, @JsonProperty("date_range") DateRangeWrapper dateRange) {
            this.type = type;
            this.dateRange = dateRange;
        }
    }
}
