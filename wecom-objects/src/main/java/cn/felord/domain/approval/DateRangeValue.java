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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.Instant;

/**
 * 时长组件
 *
 * @author dax
 * @since 2024/5/27
 */
@ToString
@Getter
public class DateRangeValue implements ContentDataValue {
    private final DateRangeWrapper dateRange;


    /**
     * Half day date range value.
     *
     * @param newBegin the new begin
     * @param newEnd   the new end
     * @return the date range value
     */
    public static DateRangeValue halfDay(Instant newBegin, Instant newEnd) {
        return new DateRangeValue(DateRangeType.HALF_DAY, newBegin, newEnd);
    }

    /**
     * Hour date range value.
     *
     * @param newBegin the new begin
     * @param newEnd   the new end
     * @return the date range value
     */
    public static DateRangeValue hour(Instant newBegin, Instant newEnd) {
        return new DateRangeValue(DateRangeType.HOUR, newBegin, newEnd);
    }

    /**
     * Instantiates a new Date range value.
     *
     * @param dateRange the date range
     */
    @JsonCreator
    DateRangeValue(@JsonProperty("date_range") DateRangeWrapper dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * Instantiates a new Date range value.
     *
     * @param type     the type
     * @param newBegin the new begin
     * @param newEnd   the new end
     */
    DateRangeValue(DateRangeType type,
                   Instant newBegin,
                   Instant newEnd) {
        this.dateRange = new DateRangeWrapper(type, newBegin, newEnd,
                Duration.between(newBegin, newEnd), null, null);
    }
}
