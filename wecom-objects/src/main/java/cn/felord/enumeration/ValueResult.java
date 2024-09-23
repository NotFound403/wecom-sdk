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
 * 结果对照表
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum ValueResult {
    /**
     * 成功
     */
    SUCCESS(1),
    /**
     * 失败
     */
    FAILURE(2),
    /**
     * 字段未找到
     */
    NOT_FOUND(3),
    /**
     * 必填字段未填写/被清空
     */
    REQUIRED(4),
    /**
     * 不支持的字段类型
     */
    NOT_SUPPORT(5);

    private final int type;

    ValueResult(int type) {
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
     * Deserialize value result.
     *
     * @param type the type
     * @return the value result
     */
    @JsonCreator
    public static ValueResult deserialize(int type) {
        return Arrays.stream(ValueResult.values())
                .filter(valueResult -> valueResult.type == type)
                .findFirst()
                .orElse(null);
    }
}
