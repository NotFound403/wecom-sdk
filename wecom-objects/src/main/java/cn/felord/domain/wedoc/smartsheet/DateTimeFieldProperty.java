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

package cn.felord.domain.wedoc.smartsheet;

import cn.felord.enumeration.DateTimeFieldFormatter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Date time field property.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class DateTimeFieldProperty {
    private final String format;
    private final Boolean autoFill;

    /**
     * Instantiates a new Date time field property.
     *
     * @param format   the format
     * @param autoFill the auto fill
     */
    @JsonCreator
    DateTimeFieldProperty(@JsonProperty("format") String format,
                          @JsonProperty("autoFill") Boolean autoFill) {
        this.format = format;
        this.autoFill = autoFill;
    }

    /**
     * Of date time field property.
     *
     * @param formatter the formatter
     * @param autoFill  the auto fill
     * @return the date time field property
     */
    public static DateTimeFieldProperty of(DateTimeFieldFormatter formatter, boolean autoFill) {
        return new DateTimeFieldProperty(formatter.getFormat(), autoFill);
    }
}
