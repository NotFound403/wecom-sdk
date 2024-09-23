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
import cn.felord.enumeration.SelectType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * 假勤组件-请假组件
 *
 * @author dax
 * @since 2024 /5/27
 */
@ToString
@Getter
public class VacationValue implements ContentDataValue {
    private final Wrapper vacation;

    /**
     * Instantiates a new Vacation value.
     *
     * @param vacation the vacation
     */
    @JsonCreator
    VacationValue(@JsonProperty("vacation") Wrapper vacation) {
        this.vacation = vacation;
    }

    /**
     * Instantiates a new Vacation value.
     *
     * @param key            {@code ApprovalTmpDetailResponse#getVacationList()}
     * @param attendanceType the attendance type
     * @param dateRange      the date range
     * @param sliceInfo      the slice info
     * @return the vacation value
     */
    public static VacationValue from(String key, AttendanceType attendanceType, DateRangeWrapper dateRange, SliceInfo sliceInfo) {
        CtrlOption options = new CtrlOption();
        options.setKey(key);
        return new VacationValue(new Wrapper(options, attendanceType, dateRange, sliceInfo));
    }

    /**
     * 请假
     *
     * @param key       the key
     * @param dateRange the date range
     * @return the vacation value
     */
    public static VacationValue leave(String key, DateRangeWrapper dateRange) {
        return from(key, AttendanceType.LEAVE, dateRange, null);
    }

    /**
     * 请假
     *
     * @param key       the key
     * @param dateRange the date range
     * @param sliceInfo the slice info
     * @return the vacation value
     * @since 1.2.8
     */
    public static VacationValue leave(String key, DateRangeWrapper dateRange, SliceInfo sliceInfo) {
        return from(key, AttendanceType.LEAVE, dateRange, sliceInfo);
    }

    /**
     * 出差
     *
     * @param key       the key
     * @param dateRange the date range
     * @return the vacation value
     */
    public static VacationValue trip(String key, DateRangeWrapper dateRange) {
        return trip(key, dateRange, null);
    }

    /**
     * 出差
     *
     * @param key       the key
     * @param dateRange the date range
     * @param sliceInfo the slice info
     * @return the vacation value
     * @since 1.2.8
     */
    public static VacationValue trip(String key, DateRangeWrapper dateRange, SliceInfo sliceInfo) {
        return from(key, AttendanceType.BUSINESS_TRIP, dateRange, sliceInfo);
    }

    /**
     * 外出
     *
     * @param key       the key
     * @param dateRange the date range
     * @return the vacation value
     */
    public static VacationValue goingOut(String key, DateRangeWrapper dateRange) {
        return goingOut(key, dateRange, null);
    }

    /**
     * 外出
     *
     * @param key       the key
     * @param dateRange the date range
     * @param sliceInfo the slice info
     * @return the vacation value
     * @since 1.2.8
     */
    public static VacationValue goingOut(String key, DateRangeWrapper dateRange, SliceInfo sliceInfo) {
        return from(key, AttendanceType.GOING_OUT, dateRange, sliceInfo);
    }

    /**
     * 加班
     *
     * @param key       the key
     * @param dateRange the date range
     * @return the vacation value
     */
    public static VacationValue overtime(String key, DateRangeWrapper dateRange) {
        return overtime(key, dateRange, null);
    }

    /**
     * 加班
     *
     * @param key       the key
     * @param dateRange the date range
     * @param sliceInfo the slice info
     * @return the vacation value
     * @since 1.2.8
     */
    public static VacationValue overtime(String key, DateRangeWrapper dateRange, SliceInfo sliceInfo) {
        return from(key, AttendanceType.OVERTIME_WORK, dateRange, sliceInfo);
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final Selector selector;
        private final Attendance attendance;

        /**
         * Instantiates a new Wrapper.
         *
         * @param selector   the selector
         * @param attendance the attendance
         */
        @JsonCreator
        Wrapper(@JsonProperty("selector") Selector selector, @JsonProperty("attendance") Attendance attendance) {
            this.selector = selector;
            this.attendance = attendance;
        }

        /**
         * Instantiates a new Wrapper.
         *
         * @param options   the options
         * @param type      the type
         * @param dateRange the date range
         * @param sliceInfo the slice info
         */
        Wrapper(CtrlOption options, AttendanceType type, DateRangeWrapper dateRange, SliceInfo sliceInfo) {
            this(new Selector(Collections.singletonList(options)), new Attendance(type, dateRange, sliceInfo));
        }
    }

    /**
     * The type Selector.
     */
    @ToString
    @Getter
    public static class Selector {
        private final SelectType type = SelectType.SINGLE;
        private final List<CtrlOption> options;

        /**
         * Instantiates a new Selector.
         *
         * @param options the options
         */
        @JsonCreator
        Selector(@JsonProperty("options") List<CtrlOption> options) {
            this.options = options;
        }
    }

    /**
     * The type Attendance.
     */
    @ToString
    @Getter
    public static class Attendance {
        private final AttendanceType type;
        private final DateRangeWrapper dateRange;
        private final SliceInfo sliceInfo;

        /**
         * Instantiates a new Attendance.
         *
         * @param type      the type
         * @param dateRange the date range
         * @param sliceInfo the slice info
         */
        @JsonCreator
        Attendance(@JsonProperty("type") AttendanceType type,
                   @JsonProperty("date_range") DateRangeWrapper dateRange,
                   @JsonProperty("slice_info") SliceInfo sliceInfo) {
            this.type = type;
            this.dateRange = dateRange;
            this.sliceInfo = sliceInfo;
        }
    }
}
