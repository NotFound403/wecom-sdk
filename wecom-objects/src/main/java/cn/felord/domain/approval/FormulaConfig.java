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
 * 公式配置
 * <p>
 * 示例：{@code {"formula":{"tokens":["Money-26325626","+","Money-93708401","+","Money-78842584","*","2"]}}}
 *
 * @author dax
 * @since 2024/5/27 8:44
 */
@ToString
@Getter
public class FormulaConfig implements ControlConfig {
    private final Wrapper formula;

    /**
     * Instantiates a new Formula config.
     *
     * @param formula the formula
     */
    @JsonCreator
    FormulaConfig(@JsonProperty("formula") Wrapper formula) {
        this.formula = formula;
    }

    /**
     * From formula config.
     *
     * @param tokens the tokens
     * @return the formula config
     */
    public static FormulaConfig from(List<String> tokens) {
        return new FormulaConfig(new Wrapper(tokens));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final List<String> tokens;

        /**
         * Instantiates a new Wrapper.
         *
         * @param tokens the tokens
         */
        @JsonCreator
        Wrapper(@JsonProperty("tokens") List<String> tokens) {
            this.tokens = tokens;
        }
    }
}
