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
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.Instant;

/**
 * 时长组件
 *
 * @author dax
 * @since 2023 /5/27
 */
@Data
public class DateRangeValue implements ContentDataValue {

    private final Wrapper dateRange;

    /**
     * Instantiates a new Date range value.
     *
     * @param dateRange the date range
     */
    @JsonCreator
    DateRangeValue(@JsonProperty("date_range") Wrapper dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * Instantiates a new Date range value.
     *
     * @param type        the type
     * @param newBegin    the new begin
     * @param newEnd      the new end
     */
    public DateRangeValue(DateRangeType type,
                          Instant newBegin,
                          Instant newEnd) {
        this.dateRange = new Wrapper(type, newBegin, newEnd, Duration.between(newBegin, newEnd));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final DateRangeType type;
        private final Instant newBegin;
        private final Instant newEnd;
        @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "SECONDS")
        private final Duration newDuration;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type        the type
         * @param newBegin    the new begin
         * @param newEnd      the new end
         * @param newDuration the new duration
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") DateRangeType type,
                @JsonProperty("new_begin") Instant newBegin,
                @JsonProperty("new_end") Instant newEnd,
                @JsonProperty("new_duration") Duration newDuration) {
            this.type = type;
            this.newBegin = newBegin;
            this.newEnd = newEnd;
            this.newDuration = newDuration;
        }
    }

}
