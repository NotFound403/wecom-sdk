/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
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
 * @author dax
 * @since 2023/3/10 9:35
 */
@Getter
public class UpdateFormQuestionRequest extends AbstractUpdateFormRequest {
    private final String formid;
    private final FormInfo formInfo;

    public UpdateFormQuestionRequest(String formid, String formTitle, String formDesc, String formHeader, FormQuestion formQuestion) {
        super(FormOperType.QUESTION);
        this.formid = formid;
        FormInfo info = new FormInfo(formTitle);
        info.setFormDesc(formDesc);
        info.setFormHeader(formHeader);
        info.setFormQuestion(formQuestion);
        this.formInfo = info;
    }
}
