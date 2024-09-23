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

package cn.felord.domain.wedoc.doc;

import cn.felord.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Cell value.
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class CellValue {
    private final String text;
    private final CellLink link;


    /**
     * Instantiates a new Cell value.
     *
     * @param text the text
     * @param url  the url
     */
    @JsonCreator
    CellValue(@JsonProperty("text") String text, @JsonProperty("url") String url) {
        if (StringUtils.hasText(url)) {
            this.text = null;
            this.link = new CellLink(text, url);
        } else {
            this.text = text;
            this.link = null;
        }
    }

    /**
     * 文本
     *
     * @param text the text
     * @return the cell value
     */
    public static CellValue text(String text) {
        return new CellValue(text, null);
    }

    /**
     * 链接
     *
     * @param text the text
     * @param url  the url
     * @return the cell value
     */
    public static CellValue link(String text, String url) {
        return new CellValue(text, url);
    }

    public boolean isLink() {
        return link != null;
    }
}
