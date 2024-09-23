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
 * 收集表文本校验详情
 *
 * @author dax
 * @see TextValidationType
 * @since 2024/7/3 15:28
 */
public enum TextValidationDetail {
    /**
     * 字符个数不超过
     */
    CHAR_LTE(1),
    /**
     * 字符数不小于
     */
    CHAR_GTE(2),
    /**
     * 字符数等于
     */
    CHAR_EQ(3),
    /**
     * 数字没有限制
     */
    NUM_NO_LIMIT(4),
    /**
     * 数字大于
     */
    NUM_GT(5),
    /**
     * 数字大于等于
     */
    NUM_GTE(6),
    /**
     * 数字小于
     */
    NUM_LT(7),
    /**
     * 数字小于等于
     */
    NUM_LTE(8),
    /**
     * 数字在范围之间
     */
    NUM_RANGE(9),
    /**
     * 数字不在范围之间
     */
    NUM_OUT_RANGE(10),
    /**
     * 整数
     */
    NUM_INT(11);

    private final int type;

    TextValidationDetail(int type) {
        this.type = type;
    }

    /**
     * Deserialize TextValidationDetail
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static TextValidationDetail deserialize(int type) {
        return Arrays.stream(TextValidationDetail.values())
                .filter(textValidationDetail -> textValidationDetail.type == type)
                .findFirst()
                .orElse(null);
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

}
