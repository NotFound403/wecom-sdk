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
 * The type Select sheet field.
 *
 * @author dax
 * @since 2024 /9/5
 */
@ToString(callSuper = true)
@Getter
public class SelectSheetField extends SheetField {
    private final SelectFieldProperty propertySelect;


    /**
     * Create select sheet field.
     *
     * @param fieldTitle     the field title
     * @param selectProperty the select property
     * @return the progress sheet field
     */
    public static SelectSheetField create(String fieldTitle, SelectFieldProperty selectProperty) {
        return update(null, fieldTitle, selectProperty);
    }

    /**
     * Update select sheet field.
     *
     * @param fieldId        the field id
     * @param fieldTitle     the field title
     * @param selectProperty the select property
     * @return the progress sheet field
     */
    public static SelectSheetField update(String fieldId, String fieldTitle, SelectFieldProperty selectProperty) {
        return new SelectSheetField(fieldId, SheetFieldType.FIELD_TYPE_SELECT, fieldTitle, selectProperty);
    }

    /**
     * Instantiates a new Select sheet field.
     *
     * @param fieldId        the field id
     * @param fieldType      the field type
     * @param fieldTitle     the field title
     * @param selectProperty the select property
     */
    @JsonCreator
    SelectSheetField(@JsonProperty("field_id") String fieldId,
                            @JsonProperty("field_type") SheetFieldType fieldType,
                            @JsonProperty("field_title") String fieldTitle,
                     @JsonProperty("property_select") SelectFieldProperty selectProperty) {
        super(fieldId, fieldType, fieldTitle);
        this.propertySelect = selectProperty;
    }
}
