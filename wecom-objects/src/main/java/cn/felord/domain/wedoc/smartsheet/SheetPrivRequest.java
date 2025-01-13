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

import lombok.Data;

import java.util.Set;

/**
 * The type Sheet priv request.
 *
 * @author dax
 * @since 2024 /12/25
 */
@Data
public class SheetPrivRequest {
    private final String docid;
    private final Integer type;
    private final Set<String> ruleIdList;

    /**
     * Instantiates a new Sheet auth request.
     *
     * @param docid      the docid
     * @param type       the type
     * @param ruleIdList the rule id list
     */
    SheetPrivRequest(String docid, Integer type, Set<String> ruleIdList) {
        this.docid = docid;
        this.type = type;
        this.ruleIdList = ruleIdList;
    }

    /**
     * 全员权限
     *
     * @param docId the doc id
     * @return the sheet auth request
     */
    public static SheetPrivRequest all(String docId) {
        return new SheetPrivRequest(docId, 1, null);
    }

    /**
     * 额外权限
     *
     * @param docId      the doc id
     * @param ruleIdList the rule id list
     * @return the sheet auth request
     */
    public static SheetPrivRequest additional(String docId, Set<String> ruleIdList) {
        return new SheetPrivRequest(docId, 2, ruleIdList);
    }
}
