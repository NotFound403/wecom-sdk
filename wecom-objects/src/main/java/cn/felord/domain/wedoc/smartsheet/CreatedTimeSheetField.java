/*
 * Copyright (c) 2025. felord.cn
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
 * The type Created time sheet field.
 *
 * @author dax
 * @since 2024 /9/5
 */
@ToString(callSuper = true)
@Getter
public class CreatedTimeSheetField extends SheetField {
    private final TimeFieldProperty propertyCreatedTime;

    /**
     * Create created time sheet field.
     *
     * @param fieldTitle   the field title
     * @param timeProperty the time property
     * @return the created time sheet field
     */
    public static CreatedTimeSheetField create(String fieldTitle, TimeFieldProperty timeProperty) {
        return update(null, fieldTitle, timeProperty);
    }

    /**
     * Update created time sheet field.
     *
     * @param fieldId      the field id
     * @param fieldTitle   the field title
     * @param timeProperty the time property
     * @return the created time sheet field
     */
    public static CreatedTimeSheetField update(String fieldId, String fieldTitle, TimeFieldProperty timeProperty) {
        return new CreatedTimeSheetField(fieldId, SheetFieldType.FIELD_TYPE_CREATED_TIME, fieldTitle, timeProperty);
    }

    /**
     * Instantiates a new Created time sheet field.
     *
     * @param fieldId      the field id
     * @param fieldType    the field type
     * @param fieldTitle   the field title
     * @param timeProperty the time property
     */
    @JsonCreator
    CreatedTimeSheetField(@JsonProperty("field_id") String fieldId,
                          @JsonProperty("field_type") SheetFieldType fieldType,
                          @JsonProperty("field_title") String fieldTitle,
                          @JsonProperty("property_created_time") TimeFieldProperty timeProperty) {
        super(fieldId, fieldType, fieldTitle);
        this.propertyCreatedTime = timeProperty;
    }
}
