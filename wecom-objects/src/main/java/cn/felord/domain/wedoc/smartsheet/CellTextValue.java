/*
 * Copyright (c) 2025. felord.cn
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

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Cell text value.
 *
 * @author dax
 * @since 2024 /12/23
 */
@ToString
@Getter
public class CellTextValue {
    private final String type;
    private final String text;
    private final String link;

    /**
     * Instantiates a new Cell text value.
     *
     * @param type the type
     * @param text the text
     * @param link the link
     */
    @JsonCreator
    CellTextValue(String type, String text, String link) {
        this.type = type;
        this.text = text;
        this.link = link;
    }

    /**
     * Text cell text value.
     *
     * @param text the text
     * @return the cell text value
     */
    public static CellTextValue text(String text) {
        return new CellTextValue("text", text, null);
    }

}
