/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * 公式配置
 * <p>
 * 示例：{@code {"formula":{"tokens":["Money-26325626","+","Money-93708401","+","Money-78842584","*","2"]}}}
 *
 * @author dax
 * @since 2023 /5/27 8:44
 */
@Data
public class FormulaConfig {
    private Wrapper formula;

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private List<String> tokens;
    }
}
