/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.enumeration.AttendanceType;
import cn.felord.enumeration.SelectType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 假勤组件-请假组件
 *
 * @author dax
 * @since 2023 /5/27
 */
@ToString
@Getter
public class VacationValue implements ContentDataValue {
    private final Wrapper vacation;

    /**
     * Instantiates a new Vacation value.
     *
     * @param options   the options
     * @param type      the type
     * @param dateRange the date range
     */
    VacationValue(List<CtrlOption> options, AttendanceType type, DateRangeValue dateRange) {
        this.vacation = new Wrapper(options, type, dateRange);
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    static class Wrapper {
        private final Selector selector;
        private final Attendance attendance;

        /**
         * Instantiates a new Wrapper.
         *
         * @param options   the options
         * @param type      the type
         * @param dateRange the date range
         */
        Wrapper(List<CtrlOption> options, AttendanceType type, DateRangeValue dateRange) {
            this.selector = new Selector(options);
            this.attendance = new Attendance(type, dateRange);
        }
    }

    /**
     * The type Selector.
     */
    @ToString
    @Getter
    @RequiredArgsConstructor
    static class Selector {
        private final SelectType type = SelectType.SINGLE;
        private final List<CtrlOption> options;
    }

    /**
     * The type Attendance.
     */
    @ToString
    @Getter
    @RequiredArgsConstructor
    static class Attendance {
        private final AttendanceType type;
        private final DateRangeValue dateRange;
    }
}
