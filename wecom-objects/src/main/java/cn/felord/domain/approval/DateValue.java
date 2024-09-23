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

import cn.felord.enumeration.DateCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * 日期/日期+时间组件
 *
 * @author dax
 * @since 2024/5/25 16:15
 */
@ToString
@Getter
public class DateValue implements ContentDataValue {
    private final Wrapper date;

    /**
     * Instantiates a new Date value.
     *
     * @param date the date
     */
    @JsonCreator
    DateValue(@JsonProperty("date") Wrapper date) {
        this.date = date;
    }

    /**
     * 日期
     *
     * @param sTimestamp the date
     * @return the date value
     */
    public static DateValue date(Instant sTimestamp) {
        return new DateValue(new Wrapper(DateCtrlType.DAY, sTimestamp, null));
    }

    /**
     * 日期时间
     *
     * @param sTimestamp dateTime
     * @return the date value
     */
    public static DateValue dateTime(Instant sTimestamp) {
        return new DateValue(new Wrapper(DateCtrlType.HOUR, sTimestamp, null));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final DateCtrlType type;
        @JsonProperty("s_timestamp")
        private final Instant sTimestamp;
        private final TimezoneInfo timezoneInfo;

        /**
         * Instantiates a new Wrapper.
         *
         * @param type         the type
         * @param sTimestamp   the s timestamp
         * @param timezoneInfo the timezone info
         */
        @JsonCreator
        Wrapper(@JsonProperty("type") DateCtrlType type,
                @JsonProperty("s_timestamp") Instant sTimestamp,
                @JsonProperty("timezone_info") TimezoneInfo timezoneInfo) {
            this.type = type;
            this.sTimestamp = sTimestamp;
            this.timezoneInfo = timezoneInfo;
        }
    }
}
