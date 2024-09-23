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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Sheet properties.
 *
 * @author dax
 * @since 2024 /8/30
 */
@ToString
@Getter
public class SmartSheetProperties {
    private final String title;
    private final Integer index;
    private final String sheetId;

    /**
     * Instantiates a new Sheet properties.
     *
     * @param title the title
     * @param index the index
     */
    public SmartSheetProperties(String title, Integer index) {
        this(title, index, null);
    }

    /**
     * Instantiates a new Sheet properties.
     *
     * @param title   the title
     * @param index   the index
     * @param sheetId the sheet id
     */
    @JsonCreator
    public SmartSheetProperties(@JsonProperty("title") String title,
                                @JsonProperty("index") Integer index,
                                @JsonProperty("sheet_id") String sheetId) {
        this.title = title;
        this.index = index;
        this.sheetId = sheetId;
    }
}
