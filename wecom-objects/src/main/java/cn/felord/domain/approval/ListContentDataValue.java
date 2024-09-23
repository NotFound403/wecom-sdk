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

import cn.felord.utils.Assert;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 明细组件
 *
 * @author dax
 * @see TableConfig
 * @since 2024/7/16 17:14
 */
@Getter
@ToString
public class ListContentDataValue implements ContentDataValue {
    private final List<List<? extends ContentDataValue>> values;


    /**
     * Instantiates a new List content data value.
     *
     * @param values the values
     */
    ListContentDataValue(List<List<? extends ContentDataValue>> values) {
        this.values = values;
    }


    /**
     * Of list content data value.
     *
     * @return the list content data value
     */
    public static ListContentDataValue of() {
        return new ListContentDataValue(new ArrayList<>());
    }

    /**
     * Instantiates a new List content data value.
     *
     * @param first the first
     * @return the list content data value
     */
    public static ListContentDataValue of(List<? extends ContentDataValue> first) {
        return of().append(first);
    }

    /**
     * 多个相同明细分片
     *
     * @param next the next
     * @return the list content data next
     */
    public ListContentDataValue append(List<? extends ContentDataValue> next) {
        Assert.notEmpty(next, "next must not be empty");
        values.add(next);
        return this;
    }
}
