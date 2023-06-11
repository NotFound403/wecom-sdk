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
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Duration;
import java.time.Instant;

/**
 * @author dax
 * @since 2023/5/27
 */
@Data
public class DateRangeValue implements ContentDataValue{

    private final Wrapper dateRange;

    @JsonCreator
    public DateRangeValue(@JsonProperty("date_range") Wrapper dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private  DateRangeType type;
        private Instant newBegin;
        private Instant newEnd;
        private Duration newDuration;
    }

}
