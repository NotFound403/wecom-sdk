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

import cn.felord.enumeration.Conjunction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Filter spec.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class FilterSpec {
    private final Conjunction conjunction;
    private final List<? extends AbstractFilterCondition> conditions;


    /**
     * Instantiates a new Filter spec.
     *
     * @param conjunction the conjunction
     * @param conditions  the conditions
     */
    @JsonCreator
    FilterSpec(@JsonProperty("conjunction") Conjunction conjunction,
               @JsonProperty("conditions") List<? extends AbstractFilterCondition> conditions) {
        this.conjunction = conjunction;
        this.conditions = conditions;
    }

    /**
     * And filter spec.
     *
     * @param conditions the conditions
     * @return the filter spec
     */
    public FilterSpec and(List<? extends AbstractFilterCondition> conditions) {
        return new FilterSpec(Conjunction.CONJUNCTION_AND, conditions);
    }

    /**
     * Or filter spec.
     *
     * @param conditions the conditions
     * @return the filter spec
     */
    public FilterSpec or(List<? extends AbstractFilterCondition> conditions) {
        return new FilterSpec(Conjunction.CONJUNCTION_OR, conditions);
    }
}
