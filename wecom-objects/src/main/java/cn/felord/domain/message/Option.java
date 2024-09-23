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

import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/11/25
 */
@ToString
@Getter
public class Option {
    private final String id;
    private final String text;
    private final Boolean isChecked;


    public Option(String id, String text) {
        this(id, text, null);
    }

    public Option(String id, String text, Boolean isChecked) {
        this.id = id;
        this.text = text;
        this.isChecked = isChecked;
    }
}
