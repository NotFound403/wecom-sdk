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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 明细组件
 *
 * @author dax
 * @since 2024/5/27 10:59
 */
@ToString
@Getter
public class TableValue implements ContentDataValue {
    private final List<Wrapper> children;

    /**
     * Instantiates a new Table value.
     *
     * @param children the children
     */
    @JsonCreator
    TableValue(@JsonProperty("children") List<Wrapper> children) {
        this.children = children;
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final List<? extends ApplyContentData<? extends ContentDataValue>> list;

        /**
         * Instantiates a new Wrapper.
         *
         * @param list the list
         */
        @JsonCreator
        Wrapper(@JsonProperty("list") List<? extends ApplyContentData<? extends ContentDataValue>> list) {
            this.list = list;
        }
    }
}
