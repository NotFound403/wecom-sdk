/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.domain.common.SingleText;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 公式组件
 *
 * @author dax
 * @since 2023 /5/27 17:21
 */
@ToString
@Getter
public class FormulaValue implements ContentDataValue {
    private final SingleText formula;

    /**
     * Instantiates a new Formula value.
     *
     * @param formula the formula
     */
    @JsonCreator
    FormulaValue(@JsonProperty("formula") SingleText formula) {
        this.formula = formula;
    }

    /**
     * Instantiates a new Formula value.
     *
     * @return the formula value
     */
    public static FormulaValue create() {
        return new FormulaValue(new SingleText(null));
    }
}
