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

package cn.felord.domain.message;

import lombok.Data;

import java.util.List;

/**
 * The type Button selection.
 *
 * @author felord
 * @since 2021 /11/23 16:09
 */
@Data
public class ButtonSelection {
    private final String questionKey;
    private final List<BtnOption> optionList;
    private String title;
    private String selectedId;


    /**
     * The type Btn option.
     */
    @Data
    public static class BtnOption {
        private final String id;
        private final String text;
    }
}
