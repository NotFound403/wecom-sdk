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
    private final Integer style;

    /**
     * Instantiates a new Select field option.
     *
     * @param id    the id
     * @param text  the text
     * @param style the style
     */
    @JsonCreator
    SelectFieldOption(@JsonProperty("id") String id,
                      @JsonProperty("text") String text,
                      @JsonProperty("style") Integer style) {
        this.id = id;
        this.text = text;
        this.style = style;
    }

    /**
     * Instantiates a new Select field option.
     *
     * @param id    the id
     * @param text  the text
     * @param style the style
     */
    public SelectFieldOption(String id, String text, SelectFieldStyle style) {
        this(id, text, style.getStyle());
    }
}
