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

import cn.felord.domain.externalcontact.MiniProgramStyle;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Multi style.
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum MultiStyle implements MiniProgramStyle {
    /**
     * Multi style 1 multi style.
     */
    MULTI_STYLE_1(1),
    /**
     * Multi style 2 multi style.
     */
    MULTI_STYLE_2(2);

    private final int style;

    MultiStyle(int style) {

        this.style = style;
    }

    @JsonValue
    @Override
    public int getStyle() {
        return style;
    }

    /**
     * Deserialize multi style.
     *
     * @param style the style
     * @return the multi style
     */
    @JsonCreator
    public static MultiStyle deserialize(int style) {
        return Arrays.stream(MultiStyle.values())
                .filter(multiStyle -> multiStyle.style == style)
                .findFirst()
                .orElse(null);
    }
}
