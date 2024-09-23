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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CommonField;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * The type Required form.
 */
@ToString
@RequiredArgsConstructor
@Getter
public class ActivateForm {
    private final Boolean canModify;
    private List<RichField> richFieldList;
    private List<String> customFieldList;
    private List<CommonField> commonFieldIdList;

    /**
     * Rich field list activate form.
     *
     * @param richFieldList the rich field list
     * @return the activate form
     */
    public ActivateForm richFieldList(List<RichField> richFieldList) {
        this.richFieldList = richFieldList;
        return this;
    }

    /**
     * Custom field list activate form.
     *
     * @param customFieldList the custom field list
     * @return the activate form
     */
    public ActivateForm customFieldList(List<String> customFieldList) {
        this.customFieldList = customFieldList;
        return this;
    }

    /**
     * Common field id list activate form.
     *
     * @param commonFieldIdList the common field id list
     * @return the activate form
     */
    public ActivateForm commonFieldIdList(List<CommonField> commonFieldIdList) {
        this.commonFieldIdList = commonFieldIdList;
        return this;
    }
}
