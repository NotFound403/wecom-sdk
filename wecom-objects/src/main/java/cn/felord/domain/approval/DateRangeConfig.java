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

import cn.felord.enumeration.DateRangeType;
import cn.felord.enumeration.HolidayType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;

/**
 * The type Date range config.
 *
 * @author dax
 * @since 2024/5/25 17:17
 */
@ToString
@Getter
public class DateRangeConfig implements ControlConfig {
    private final DateRange dateRange;

    /**
     * Instantiates a new Date range config.
     *
     * @param dateRange the date range
     */
    @JsonCreator
    DateRangeConfig(@JsonProperty("date_range") DateRange dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * From date range config.
     *
     * @param type            the type
     * @param officialHoliday the official holiday
     * @param perdayDuration  the perday duration
     * @return the date range config
     */
    public static DateRangeConfig from(DateRangeType type,
                                       HolidayType officialHoliday,
                                       Duration perdayDuration) {
        return new DateRangeConfig(new DateRange(type, officialHoliday, perdayDuration));
    }


}
