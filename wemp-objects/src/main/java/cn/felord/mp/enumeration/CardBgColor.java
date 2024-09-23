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
package cn.felord.mp.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/**
 * 背景色
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
public enum CardBgColor {
    /**
     * Color 010 coupon bg color.
     */
    COLOR010("Color010", "#63b359"),
    /**
     * COLOR 020 coupon bg color.
     */
    COLOR020("Color020", "#2c9f67"),
    /**
     * COLOR 030 coupon bg color.
     */
    COLOR030("Color030", "#509fc9"),
    /**
     * COLOR 040 coupon bg color.
     */
    COLOR040("Color040", "#5885cf"),
    /**
     * COLOR 050 coupon bg color.
     */
    COLOR050("Color050", "#9062c0"),
    /**
     * COLOR 060 coupon bg color.
     */
    COLOR060("Color060", "#d09a45"),
    /**
     * COLOR 070 coupon bg color.
     */
    COLOR070("Color070", "#e4b138"),
    /**
     * COLOR 080 coupon bg color.
     */
    COLOR080("Color080", "#ee903c"),
    /**
     * COLOR 090 coupon bg color.
     */
    COLOR081("Color081", "#f08500"),
    /**
     * Color 082 card bg color.
     */
    COLOR082("Color082", "#a9d92d"),
    /**
     * Color 090 card bg color.
     */
    COLOR090("Color090", "#dd6549"),
    /**
     * COLOR 100 coupon bg color.
     */
    COLOR100("Color100", "#cc463d"),
    /**
     * Color 101 card bg color.
     */
    COLOR101("Color101", "#cf3e36"),
    /**
     * Color 102 card bg color.
     */
    COLOR102("Color102", "#5E6671");

    private final String value;
    private final String color;

    CardBgColor(String value, String color) {
        this.value = value;
        this.color = color;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * Deserialize card bg color.
     *
     * @param color the color
     * @return the card bg color
     */
    @JsonCreator
    public static CardBgColor deserialize(String color) {
        return Arrays.stream(CardBgColor.values())
                .filter(cardBgColor -> Objects.equals(cardBgColor.color, color))
                .findFirst()
                .orElse(null);
    }
}
