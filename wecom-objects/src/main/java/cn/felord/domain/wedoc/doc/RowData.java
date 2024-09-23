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

import java.util.Arrays;
import java.util.List;

/**
 * 行数据的资源描述
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class RowData {
    private final List<CellData> values;

    /**
     * Instantiates a new Row data.
     *
     * @param values the values
     */
    @JsonCreator
    RowData(@JsonProperty("values") List<CellData> values) {
        this.values = values;
    }

    /**
     * Of row data.
     *
     * @param values the values
     * @return the row data
     */
    public static RowData of(List<CellData> values) {
        return new RowData(values);
    }

    /**
     * Of row data.
     *
     * @param values the values
     * @return the row data
     */
    public static RowData of(CellData... values) {
        return new RowData(Arrays.asList(values));
    }
}
