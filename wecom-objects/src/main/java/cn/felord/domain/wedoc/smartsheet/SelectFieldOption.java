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

import cn.felord.enumeration.SelectFieldStyle;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Select field option.
 *
 * @author dax
 * @since 2024 /9/4
 */
@ToString
@Getter
public class SelectFieldOption {
    private final String id;
    private final String text;
    private final SelectFieldStyle style;

    /**
     * Instantiates a new Select field option.
     *
     * @param id    the id
     * @param text  the text
     * @param style the style
     */
    @JsonCreator
    public SelectFieldOption(@JsonProperty("id") String id,
                             @JsonProperty("text") String text,
                             @JsonProperty("style") SelectFieldStyle style) {
        this.id = id;
        this.text = text;
        this.style = style;
    }

    /**
     * 选择时以ID为准，当选项存在时，通过ID识别选项，当需要新增选项，则不填写此字段
     *
     * @param id the id
     * @return the select field option
     */
    public static SelectFieldOption selectWithId(String id) {
        return new SelectFieldOption(id, null, null);
    }

    /**
     * 要填写的选项内容。新增选项时填写，已经存在时优先匹配已经存在的选项，否则会新增选项
     *
     * @param text the text
     * @return the select field option
     */
    public static SelectFieldOption selectWithText(String text) {
        return new SelectFieldOption(null, text, null);
    }
}
