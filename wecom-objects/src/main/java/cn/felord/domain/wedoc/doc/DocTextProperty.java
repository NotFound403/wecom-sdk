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

import lombok.Getter;
import lombok.ToString;

/**
 * 文本属性
 *
 * @author dax
 * @since 2024 /8/9
 */
@ToString
@Getter
public class DocTextProperty {
    /**
     * 是否加粗
     */
    private final boolean blod;
    /**
     * 文字颜色，十六进制RRGGBB格式
     */
    private final String color;
    /**
     * 文字的背景颜色，十六进制RRGGBB 格式
     */
    private final String backgroundColor;

    /**
     * Instantiates a new Doc text property.
     *
     * @param bold            the blod
     * @param color           the color
     * @param backgroundColor the background color
     */
    DocTextProperty(boolean bold, String color, String backgroundColor) {
        this.blod = bold;
        this.color = color;
        this.backgroundColor = backgroundColor;
    }
}
