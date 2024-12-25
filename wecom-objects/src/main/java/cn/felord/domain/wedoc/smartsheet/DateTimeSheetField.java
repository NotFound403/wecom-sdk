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

import cn.felord.enumeration.SheetFieldType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Date time sheet field.
 *
 * @author dax
 * @since 2024 /9/5
 */
@ToString(callSuper = true)
@Getter
public class DateTimeSheetField extends SheetField {
    private final DateTimeFieldProperty propertyDateTime;


    /**
     * Create date time sheet field.
     *
     * @param fieldTitle       the field title
     * @param dateTimeProperty the date time property
     * @return the date time sheet field
     */
    public static DateTimeSheetField create(String fieldTitle, DateTimeFieldProperty dateTimeProperty) {
        return update(null, fieldTitle, dateTimeProperty);
    }

    /**
     * Update date time sheet field.
     *
     * @param fieldId          the field id
     * @param fieldTitle       the field title
     * @param dateTimeProperty the date time property
     * @return the date time sheet field
     */
    public static DateTimeSheetField update(String fieldId, String fieldTitle, DateTimeFieldProperty dateTimeProperty) {
        return new DateTimeSheetField(fieldId, SheetFieldType.FIELD_TYPE_DATE_TIME, fieldTitle, dateTimeProperty);
    }

    /**
     * Instantiates a new Date time sheet field.
     *
     * @param fieldId          the field id
     * @param fieldType        the field type
     * @param fieldTitle       the field title
     * @param dateTimeProperty the date time property
     */
    @JsonCreator
    DateTimeSheetField(@JsonProperty("field_id") String fieldId,
                       @JsonProperty("field_type") SheetFieldType fieldType,
                       @JsonProperty("field_title") String fieldTitle,
                       @JsonProperty("property_date_time") DateTimeFieldProperty dateTimeProperty) {
        super(fieldId, fieldType, fieldTitle);
        this.propertyDateTime = dateTimeProperty;
    }
}
