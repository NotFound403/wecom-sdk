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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Grid data.
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class GridData {
    private final Integer startRow;
    private final Integer startColumn;
    private final List<RowData> rows;

    /**
     * Instantiates a new Grid data.
     *
     * @param startRow    the start row
     * @param startColumn the start column
     * @param rows        the rows
     */
    @JsonCreator
    GridData(@JsonProperty("start_row") Integer startRow,
             @JsonProperty("start_column") Integer startColumn,
             @JsonProperty("rows") List<RowData> rows) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.rows = rows;
    }
}
