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

import java.util.List;

/**
 * The type Formula sheet field.
 *
 * @author dax
 * @since 2025 /4/25
 */
@ToString(callSuper = true)
@Getter
public class FormulaSheetField extends SheetField {
    private final FormulaFieldProperty propertyFormula;


    /**
     * Create formula sheet field.
     *
     * @param fieldTitle   the field title
     * @param formulaModel the formula model
     * @return the formula sheet field
     */
    public static FormulaSheetField create(String fieldTitle, List<FormulaModel> formulaModel) {
        return update(null, fieldTitle, formulaModel);
    }

    /**
     * Update formula sheet field.
     *
     * @param fieldId      the field id
     * @param fieldTitle   the field title
     * @param formulaModel the formula model
     * @return the formula sheet field
     */
    public static FormulaSheetField update(String fieldId, String fieldTitle, List<FormulaModel> formulaModel) {
        return new FormulaSheetField(fieldId,
                SheetFieldType.FIELD_TYPE_FORMULA,
                fieldTitle,
                new FormulaFieldProperty(formulaModel));
    }

    /**
     * Instantiates a new Formula sheet field.
     *
     * @param fieldId         the field id
     * @param fieldType       the field type
     * @param fieldTitle      the field title
     * @param propertyFormula the property formula
     */
    @JsonCreator
    FormulaSheetField(@JsonProperty("field_id") String fieldId,
                      @JsonProperty("field_type") SheetFieldType fieldType,
                      @JsonProperty("field_title") String fieldTitle,
                      @JsonProperty("property_formula") FormulaFieldProperty propertyFormula) {
        super(fieldId, fieldType, fieldTitle);
        this.propertyFormula = propertyFormula;
    }
}
