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

/**
 * The type Date config.
 *
 * @author dax
 * @since 2024/5/25 16:15
 */
@ToString
@Getter
public class DateConfig implements ControlConfig {
    private final Wrapper date;

    /**
     * Instantiates a new Date config.
     *
     * @param date the date
     */
    @JsonCreator
    DateConfig(@JsonProperty("date") Wrapper date) {
        this.date = date;
    }

    /**
     * From date config.
     *
     * @param dateCtrlType the date ctrl type
     * @return the date config
     */
    public static DateConfig from(DateCtrlType dateCtrlType) {
        return new DateConfig(new Wrapper(dateCtrlType));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final DateCtrlType type;

        @JsonCreator
        Wrapper(@JsonProperty("type") DateCtrlType type) {
            this.type = type;
        }
    }
}
