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

import cn.felord.enumeration.DateRangeType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.Instant;

/**
 * The type Date range wrapper.
 *
 * @author dax
 * @since 2023 /12/19
 */
@ToString
@Getter
public class DateRangeWrapper {
    private final DateRangeType type;
    private final Instant newBegin;
    private final Instant newEnd;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "SECONDS")
    private final Duration newDuration;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "SECONDS")
    private final Duration perdayDuration;
    private final TimezoneInfo timezoneInfo;

    /**
     * Instantiates a new Wrapper.
     *
     * @param type           the type
     * @param newBegin       the new begin
     * @param newEnd         the new end
     * @param newDuration    the new duration
     * @param perdayDuration the perday duration
     * @param timezoneInfo   the timezone info
     */
    @JsonCreator
    DateRangeWrapper(@JsonProperty("type") DateRangeType type,
                     @JsonProperty("new_begin") Instant newBegin,
                     @JsonProperty("new_end") Instant newEnd,
                     @JsonProperty("new_duration") Duration newDuration,
                     @JsonProperty("perday_duration") Duration perdayDuration,
                     @JsonProperty("timezone_info") TimezoneInfo timezoneInfo) {
        this.type = type;
        this.newBegin = newBegin;
        this.newEnd = newEnd;
        this.newDuration = newDuration;
        this.perdayDuration = perdayDuration;
        this.timezoneInfo = timezoneInfo;
    }

    /**
     * Half day date range wrapper.
     *
     * @param newBegin the new begin
     * @param newEnd   the new end
     * @return the date range wrapper
     */
    public static DateRangeWrapper halfDay(Instant newBegin, Instant newEnd) {
        return new DateRangeWrapper(DateRangeType.HALF_DAY, newBegin, newEnd, Duration.between(newBegin, newEnd), null, null);
    }

    /**
     * Hour date range wrapper.
     *
     * @param newBegin the new begin
     * @param newEnd   the new end
     * @return the date range wrapper
     */
    public static DateRangeWrapper hour(Instant newBegin, Instant newEnd) {
        return new DateRangeWrapper(DateRangeType.HOUR, newBegin, newEnd, Duration.between(newBegin, newEnd), null, null);
    }
}
