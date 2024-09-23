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
 * The type Single select sheet field.
 *
 * @author dax
 * @since 2024 /9/5
 */
@ToString
@Getter
public class SingleSelectSheetField extends SheetField {
    private final SelectFieldProperty propertySingleSelect;

    /**
     * Instantiates a new Single select sheet field.
     *
     * @param fieldId              the field id
     * @param fieldType            the field type
     * @param propertySingleSelect the propertySingleSelect
     */
    public SingleSelectSheetField(String fieldId, SheetFieldType fieldType, SelectFieldProperty propertySingleSelect) {
        super(fieldId, fieldType);
        this.propertySingleSelect = propertySingleSelect;
    }

    /**
     * Instantiates a new Single select sheet field.
     *
     * @param fieldId              the field id
     * @param fieldType            the field type
     * @param fieldTitle           the field title
     * @param propertySingleSelect the propertySingleSelect
     */
    @JsonCreator
    public SingleSelectSheetField(@JsonProperty("field_id") String fieldId,
                                  @JsonProperty("field_type") SheetFieldType fieldType,
                                  @JsonProperty("field_title") String fieldTitle,
                                  @JsonProperty("property_single_select") SelectFieldProperty propertySingleSelect) {
        super(fieldId, fieldType, fieldTitle);
        this.propertySingleSelect = propertySingleSelect;
    }
}
