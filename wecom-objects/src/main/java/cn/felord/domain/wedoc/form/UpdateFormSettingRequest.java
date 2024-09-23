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
 * @author dax
 * @since 2023/3/16 11:24
 */
@Getter
public class UpdateFormSettingRequest extends AbstractUpdateFormRequest {
    private final String formid;
    private final SettingFormInfo formInfo;

    protected UpdateFormSettingRequest(String formid, FormSetting formSetting) {
        super(FormOperType.SETTING);
        this.formid = formid;
        SettingFormInfo info = new SettingFormInfo(null, null);
        info.setFormSetting(formSetting);
        this.formInfo = info;
    }


}
