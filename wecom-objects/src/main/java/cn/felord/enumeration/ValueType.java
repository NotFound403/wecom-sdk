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
 * 字段值类型对照表
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum ValueType {
    /**
     * 字符串
     */
    STRING(1),
    /**
     * 64位非负整数
     */
    UINT64(2),
    /**
     * 32位非负整数
     */
    UINT32(3),
    /**
     * 64位整数
     */
    INT64(4),
    /**
     * 电话号码
     */
    MOBILE(5),
    /**
     * 文件
     */
    FILE(6);

    private final int type;

    ValueType(int type) {
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
     * Deserialize value type.
     *
     * @param type the type
     * @return the value type
     */
    @JsonCreator
    public static ValueType deserialize(int type) {
        return Arrays.stream(ValueType.values())
                .filter(valueResult -> valueResult.type == type)
                .findFirst()
                .orElse(null);
    }
}
