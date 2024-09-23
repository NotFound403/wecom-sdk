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
 * The enum Single style.
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum SingleStyle implements MiniProgramStyle {
    /**
     * Single style 1 single style.
     */
    SINGLE_STYLE_1(1),
    /**
     * Single style 2 single style.
     */
    SINGLE_STYLE_2(2),
    /**
     * Single style 3 single style.
     */
    SINGLE_STYLE_3(3);

    private final int style;

    SingleStyle(int style) {

        this.style = style;
    }

    @JsonValue
    @Override
    public int getStyle() {
        return style;
    }

    /**
     * Deserialize single style.
     *
     * @param style the style
     * @return the single style
     */
    @JsonCreator
    public static SingleStyle deserialize(int style) {
        return Arrays.stream(SingleStyle.values())
                .filter(singleStyle -> singleStyle.style == style)
                .findFirst()
                .orElse(null);
    }
}
