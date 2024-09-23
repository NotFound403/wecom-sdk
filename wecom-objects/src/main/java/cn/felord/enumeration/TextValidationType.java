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
 * 收集表文本校验类型
 *
 * @author dax
 * @since 2024/7/3 15:28
 */
public enum TextValidationType {
    /**
     * 字符个数
     */
    CHAR_LENGTH(0),
    /**
     * 数字
     */
    NUMERIC(1),
    /**
     * 电子邮箱
     */
    EMAIL(2),
    /**
     * 网址
     */
    URL(3),
    /**
     * 身份证
     */
    ID_CARD(4),
    /**
     * 手机号（大陆地区）
     */
    CN_MOBILE(5),
    /**
     * 固定电话
     */
    LANDLINE(6);

    private final int type;

    TextValidationType(int type) {
        this.type = type;
    }

    /**
     * Deserialize ValidationType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static TextValidationType deserialize(int type) {
        return Arrays.stream(TextValidationType.values())
                .filter(textValidationType -> textValidationType.type == type)
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
