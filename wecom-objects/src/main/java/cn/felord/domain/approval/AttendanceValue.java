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
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * 假勤组件-出差/外出/加班组件
 *
 * @author dax
 * @since 2023 /5/27
 */
@ToString
@Getter
public class AttendanceValue implements ContentDataValue {
    private final Wrapper attendance;

    /**
     * Instantiates a new Attendance value.
     *
     * @param type      the type
     * @param dateRange the date range
     */
    public AttendanceValue(AttendanceType type, DateRangeValue dateRange) {
        this.attendance = new Wrapper(type, dateRange);
    }

    /**
     * The type Wrapper.
     */
    @Data
    static class Wrapper {
        private final AttendanceType type;
        private final DateRangeValue dateRange;
    }
}
