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
 * 小数点后的位数
 *
 * @author dax
 * @since 2021 /9/9 9:22
 */
public enum DecimalPlaces {

    /**
     * 显示原值
     */
    ORIGIN(-1),
    /**
     * 代表整数
     */
    INTEGER(0),
    /**
     * 精确到小数点后一位（1.0）
     */
    DIGIT_1(1),
    /**
     * 精确到小数点后两位（1.00）
     */
    DIGIT_2(2),
    /**
     * 精确到小数点后三位（1.000）
     */
    DIGIT_3(3),
    /**
     * 精确到小数点后四位（1.0000）
     */
    DIGIT_4(4);


    private final int type;

    DecimalPlaces(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize DecimalPlaces
     *
     * @param type the type
     * @return the DecimalPlaces
     */
    @JsonCreator
    public static DecimalPlaces deserialize(int type) {
        return Arrays.stream(DecimalPlaces.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
