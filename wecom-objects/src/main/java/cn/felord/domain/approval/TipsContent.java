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

import java.util.List;

/**
 * The type Tips content.
 *
 * @author dax
 * @since 2024 /1/24
 */
@ToString
@Getter
public class TipsContent {
    private final String lang;
    private final SubTexts text;

    /**
     * Instantiates a new Tips content.
     *
     * @param lang the lang
     * @param text the text
     */
    @JsonCreator
    TipsContent(@JsonProperty("lang") String lang, @JsonProperty("text") SubTexts text) {
        this.lang = lang;
        this.text = text;
    }

    /**
     * 中文提示
     *
     * @param subText the sub text
     * @return the tips content
     * @see TipSubText#text(String) 纯文本
     * @see TipSubText#link(String, String) 链接
     */
    public static TipsContent zhCN(List<TipSubText<?>> subText) {
        return from("zh_CN", subText);
    }

    /**
     * 英文提示
     *
     * @param subText the sub text
     * @return the tips content
     */
    public static TipsContent en(List<TipSubText<?>> subText) {
        return from("en", subText);
    }

    /**
     * From tips content.
     *
     * @param lang    the lang
     * @param subText the sub text
     * @return the tips content
     * @see TipSubText#text(String) 纯文本
     * @see TipSubText#link(String, String) 链接
     */
    public static TipsContent from(String lang, List<TipSubText<?>> subText) {
        return new TipsContent(lang, new SubTexts(subText));
    }
}
