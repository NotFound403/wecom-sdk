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

import cn.felord.enumeration.FormOperType;
import lombok.Getter;

/**
 * The type Update setting form question request.
 *
 * @author dax
 * @since 2024/3/10 9:35
 */
@Getter
public class UpdateSettingFormQuestionRequest extends AbstractUpdateFormRequest {
    private final String formid;
    private final SettingFormInfo formInfo;

    /**
     * Instantiates a new Update setting form question request.
     *
     * @param formid       the formid
     * @param formTitle    the form title
     * @param formDesc     the form desc
     * @param formHeader   the form header
     * @param formQuestion the form question
     */
    @Deprecated
    public UpdateSettingFormQuestionRequest(String formid, String formTitle, String formDesc, String formHeader, SettingFormQuestion formQuestion) {
        super(FormOperType.QUESTION);
        this.formid = formid;
        SettingFormInfo info = new SettingFormInfo(formTitle, formQuestion);
        info.setFormDesc(formDesc);
        info.setFormHeader(formHeader);
        this.formInfo = info;
    }

    /**
     * Instantiates a new Update setting form question request.
     *
     * @param formid       the formid
     * @param formTitle    the form title
     * @param formQuestion the form question
     */
    public UpdateSettingFormQuestionRequest(String formid, String formTitle, SettingFormQuestion formQuestion) {
        super(FormOperType.QUESTION);
        this.formid = formid;
        this.formInfo = new SettingFormInfo(formTitle, formQuestion);
    }

    /**
     * Form desc update setting form question request.
     *
     * @param formDesc the form desc
     * @return the update setting form question request
     */
    public UpdateSettingFormQuestionRequest formDesc(String formDesc) {
        this.formInfo.setFormDesc(formDesc);
        return this;
    }

    /**
     * Form header update setting form question request.
     *
     * @param formHeader the form header
     * @return the update setting form question request
     */
    public UpdateSettingFormQuestionRequest formHeader(String formHeader) {
        this.formInfo.setFormHeader(formHeader);
        return this;
    }
}
