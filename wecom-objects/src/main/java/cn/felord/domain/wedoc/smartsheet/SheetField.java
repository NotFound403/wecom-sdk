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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Sheet field.
 *
 * @author dax
 * @since 2024 /9/4
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "fieldType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SheetField.class, name = "FIELD_TYPE_TEXT"),
        @JsonSubTypes.Type(value = NumberSheetField.class, name = "FIELD_TYPE_NUMBER"),
        @JsonSubTypes.Type(value = CurrencySheetField.class, name = "FIELD_TYPE_CHECKBOX"),
        @JsonSubTypes.Type(value = DateTimeSheetField.class, name = "FIELD_TYPE_DATE_TIME"),
        @JsonSubTypes.Type(value = SheetField.class, name = "FIELD_TYPE_IMAGE"),
        @JsonSubTypes.Type(value = AttachmentSheetField.class, name = "FIELD_TYPE_ATTACHMENT"),
        @JsonSubTypes.Type(value = UserSheetField.class, name = "FIELD_TYPE_USER"),
        @JsonSubTypes.Type(value = UrlSheetField.class, name = "FIELD_TYPE_URL"),
        @JsonSubTypes.Type(value = SelectSheetField.class, name = "FIELD_TYPE_SELECT"),
        @JsonSubTypes.Type(value = UserSheetField.class, name = "FIELD_TYPE_CREATED_USER"),
        @JsonSubTypes.Type(value = UserSheetField.class, name = "FIELD_TYPE_MODIFIED_USER"),
        @JsonSubTypes.Type(value = CreatedTimeSheetField.class, name = "FIELD_TYPE_CREATED_TIME"),
        @JsonSubTypes.Type(value = ModifiedTimeSheetField.class, name = "FIELD_TYPE_MODIFIED_TIME"),
        @JsonSubTypes.Type(value = ProgressSheetField.class, name = "FIELD_TYPE_PROGRESS"),
        @JsonSubTypes.Type(value = SheetField.class, name = "FIELD_TYPE_PHONE_NUMBER"),
        @JsonSubTypes.Type(value = SheetField.class, name = "FIELD_TYPE_EMAIL"),
        @JsonSubTypes.Type(value = SingleSelectSheetField.class, name = "FIELD_TYPE_SINGLE_SELECT"),
        @JsonSubTypes.Type(value = ReferenceSheetField.class, name = "FIELD_TYPE_REFERENCE"),
        @JsonSubTypes.Type(value = LocationSheetField.class, name = "FIELD_TYPE_LOCATION"),
        @JsonSubTypes.Type(value = CurrencySheetField.class, name = "FIELD_TYPE_CURRENCY"),
        @JsonSubTypes.Type(value = WwGroupSheetField.class, name = "FIELD_TYPE_WWGROUP"),
        @JsonSubTypes.Type(value = AutoNumberSheetField.class, name = "FIELD_TYPE_AUTONUMBER")
})
@ToString
@Getter
public class SheetField {
    private final String fieldId;
    private final SheetFieldType fieldType;
    private final String fieldTitle;

    /**
     * Instantiates a new Sheet field.
     *
     * @param fieldId   the field id
     * @param fieldType the field type
     */
    public SheetField(String fieldId, SheetFieldType fieldType) {
        this(fieldId, fieldType, null);
    }

    /**
     * Instantiates a new Sheet field.
     *
     * @param fieldId    the field id
     * @param fieldType  the field type
     * @param fieldTitle the field title
     */
    @JsonCreator
    public SheetField(@JsonProperty("field_id") String fieldId,
                      @JsonProperty("field_type") SheetFieldType fieldType,
                      @JsonProperty("field_title") String fieldTitle) {
        this.fieldId = fieldId;
        this.fieldType = fieldType;
        this.fieldTitle = fieldTitle;
    }
}
