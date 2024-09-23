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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 多选选项样式颜色
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum SelectFieldStyle {

    /**
     * 浅红
     */
    LIGHT_RED(1),
    /**
     * 浅橙
     */
    LIGHT_ORANGE(2),
    /**
     * 浅天蓝
     */
    LIGHT_SKY_BLUE(3),
    /**
     * 浅绿
     */
    AQUA(4),
    /**
     * 浅紫
     */
    LIGHT_PURPLE(5),
    /**
     * 浅粉红
     */
    LIGHT_PINK(6),
    /**
     * 浅灰
     */
    LIGHT_GRAY(7),
    /**
     * 白
     */
    WHITE(8);


    private final int style;

    SelectFieldStyle(int style) {
        this.style = style;
    }

    /**
     * Gets style.
     *
     * @return the style
     */
    @JsonValue
    public int getStyle() {
        return style;
    }

    /**
     * Deserialize select field style.
     *
     * @param style the style
     * @return the select field style
     */
    @JsonCreator
    public static SelectFieldStyle deserialize(int style) {
        return Arrays.stream(SelectFieldStyle.values())
                .filter(contactType -> contactType.style == style)
                .findFirst()
                .orElse(null);
    }
}
