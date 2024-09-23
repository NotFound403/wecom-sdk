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

import lombok.Getter;
import lombok.ToString;

/**
 * 新增工作表
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class AddSheetRequest {
    /**
     * 工作表名称
     */
    private final String sheetName;
    /**
     * 新增工作表的初始行数
     */
    private final Integer rowCount;
    /**
     * 新增工作表的初始列数
     */
    private final Integer columnCount;

    /**
     * Instantiates a new Add sheet request.
     *
     * @param sheetName   the sheet name
     * @param rowCount    the row count
     * @param columnCount the column count
     */
    AddSheetRequest(String sheetName, Integer rowCount, Integer columnCount) {
        this.sheetName = sheetName;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }
}
