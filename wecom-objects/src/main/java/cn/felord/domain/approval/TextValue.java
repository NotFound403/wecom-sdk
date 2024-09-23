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

import cn.felord.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Text value.
 *
 * @author dax
 * @since 2024 /5/26
 */
@ToString
@Getter
public class TextValue implements ContentDataValue {
    private final String text;

    /**
     * Instantiates a new Text value.
     *
     * @param text the text
     */
    @JsonCreator
    TextValue(@JsonProperty("text") String text) {
        this.text = text;
    }

    /**
     * From text value.
     *
     * @param text the text
     * @return the text value
     */
    public static TextValue from(String text) {
        return StringUtils.hasText(text) ? new TextValue(text) : nullValue();
    }

    /**
     * null value.
     *
     * @return the text value
     */
    public static TextValue nullValue() {
        return new TextValue("");
    }

    /**
     * Tip text value.
     *
     * @return the text value
     */
    public static TextValue tip() {
        return nullValue();
    }
}
