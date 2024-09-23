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
 * 在指定位置插入表格，表格大小限制：
 *
 * <ol>
 *     <li>行数不大于100</li>
 *     <li>列数不大于60</li>
 *     <li>单元格总数不大于1000</li>
 * </ol>
 *
 * @author dax
 * @since 2024 /8/9
 */
@ToString
@Getter
public class DocInsertTable {
    /**
     * 表格行数
     */
    private final int rows;
    /**
     * 表格列数
     */
    private final int cols;
    /**
     * 位置
     */
    private final DocLocation location;

    /**
     * Instantiates a new Doc insert table.
     *
     * @param index the index
     * @param rows  the rows
     * @param cols  the cols
     */
    DocInsertTable(int index, int rows, int cols) {
        this(new DocLocation(index), rows, cols);
    }

    /**
     * Instantiates a new Doc insert table.
     *
     * @param location the location
     * @param cols     the cols
     * @param rows     the rows
     */
    DocInsertTable(DocLocation location, int cols, int rows) {
        this.location = location;
        this.cols = cols;
        this.rows = rows;
    }
}
