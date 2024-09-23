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

package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.TextValidationDetail;
import cn.felord.enumeration.TextValidationType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * Form文本额外校验
 *
 * @author dax
 * @since 2024/8/4 11:46
 */
@ToString
@Getter
public class TextSetting {
    private final TextValidationType validationType;
    private TextValidationDetail validationDetail;
    private Integer charLen;
    private Long numberMin;
    private Long numberMax;


    /**
     * Instantiates a new Text setting.
     *
     * @param validationType the validation type
     */

    public TextSetting(TextValidationType validationType) {
        this.validationType = validationType;
    }

    @JsonCreator
    TextSetting(@JsonProperty("validation_type") TextValidationType validationType,
                @JsonProperty("validation_detail") TextValidationDetail validationDetail,
                @JsonProperty("char_len") Integer charLen,
                @JsonProperty("number_min") Long numberMin,
                @JsonProperty("number_max") Long numberMax) {
        this.validationType = validationType;
        this.validationDetail = validationDetail;
        this.charLen = charLen;
        this.numberMin = numberMin;
        this.numberMax = numberMax;
    }

    /**
     * Validation detail text setting.
     *
     * @param validationDetail the validation detail
     * @return the text setting
     */
    public TextSetting validationDetail(TextValidationDetail validationDetail) {
        this.validationDetail = validationDetail;
        return this;
    }

    /**
     * Char len text setting.
     *
     * @param charLen the char len
     * @return the text setting
     */
    public TextSetting charLen(int charLen) {
        this.charLen = charLen;
        return this;
    }

    /**
     * Number min text setting.
     *
     * @param numberMin the number min
     * @return the text setting
     */
    public TextSetting numberMin(long numberMin) {
        this.numberMin = numberMin;
        return this;
    }

    /**
     * Number max text setting.
     *
     * @param numberMax the number max
     * @return the text setting
     */
    public TextSetting numberMax(long numberMax) {
        this.numberMax = numberMax;
        return this;
    }
}
