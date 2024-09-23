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
 * 字段类型说明
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum FieldType {
    /**
     * 文本类型
     */
    TEXT(1),
    /**
     * 选项类型
     */
    OPTION(2),
    /**
     * 时间类型
     */
    TIME(3),
    /**
     * 图片类型
     */
    IMAGE(4),
    /**
     * 单个文件类型
     */
    SINGLE_FILE(5),
    /**
     * 多个文件类型
     */
    MULTIPLE_FILE(6);

    private final int type;

    FieldType(int type) {
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
     * Deserialize FieldType.
     *
     * @param type the type
     * @return the value type
     */
    @JsonCreator
    public static FieldType deserialize(int type) {
        return Arrays.stream(FieldType.values())
                .filter(valueResult -> valueResult.type == type)
                .findFirst()
                .orElse(null);
    }
}
