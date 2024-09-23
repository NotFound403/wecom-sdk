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

import java.util.List;

/**
 * The type Sort spec.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class SortSpec {
    private final List<SortField> sortInfos;

    /**
     * Instantiates a new Sort spec.
     *
     * @param sortInfos the sort infos
     */
    @JsonCreator
    SortSpec(@JsonProperty("sort_infos") List<SortField> sortInfos) {
        this.sortInfos = sortInfos;
    }

    /**
     * From sort spec.
     *
     * @param sortInfos the sort infos
     * @return the sort spec
     */
    public static SortSpec from(List<SortField> sortInfos) {
        return new SortSpec(sortInfos);
    }
}
