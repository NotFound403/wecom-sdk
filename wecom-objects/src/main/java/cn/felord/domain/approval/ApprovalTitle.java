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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Approval title.
 *
 * @author dax
 * @since 2024/5/25 14:25
 */
@ToString
@Getter
public class ApprovalTitle {
    private final String text;
    private final String lang;

    /**
     * Instantiates a new Approval title.
     *
     * @param text the text
     * @param lang the lang
     */
    @JsonCreator
    public ApprovalTitle(@JsonProperty("text") String text, @JsonProperty("lang") String lang) {
        this.text = text;
        this.lang = lang;
    }

    /**
     * Createzh cn approval title.
     *
     * @param text the text
     * @return the approval title
     */
    public static ApprovalTitle zhCN(String text) {
        return new ApprovalTitle(text, "zh_CN");
    }

}
