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
import cn.felord.enumeration.DateRangeType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Attendance config.
 *
 * @author dax
 * @since 2024/5/25 16:37
 */
@ToString
@Getter
public class AttendanceConfig implements ControlConfig {
    private final Wrapper attendance;


    /**
     * Instantiates a new Attendance config.
     *
     * @param attendance the attendance
     */
    @JsonCreator
    AttendanceConfig(@JsonProperty("attendance") Wrapper attendance) {
        this.attendance = attendance;
    }

    /**
     * From attendance config.
     *
     * @param attendanceType the attendance type
     * @param dateRangeType  the date range type
     * @return the attendance config
     */
    public static AttendanceConfig from(AttendanceType attendanceType, DateRangeType dateRangeType) {
        return new AttendanceConfig(new Wrapper(attendanceType, new AttendanceDateRange(dateRangeType)));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final AttendanceType type;
        private final AttendanceDateRange dateRange;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type      the type
         * @param dateRange the date range
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") AttendanceType type, @JsonProperty("dateRange") AttendanceDateRange dateRange) {
            this.type = type;
            this.dateRange = dateRange;
        }
    }

    /**
     * The type Attendance date range.
     */
    @ToString
    @Getter
    public static class AttendanceDateRange {
        private final DateRangeType type;

        /**
         * Instantiates a new Attendance date range.
         *
         * @param type the type
         */
        @JsonCreator
        AttendanceDateRange(@JsonProperty("type") DateRangeType type) {
            this.type = type;
        }
    }
}
