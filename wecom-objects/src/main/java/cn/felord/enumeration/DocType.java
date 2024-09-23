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
 * The DocType
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum DocType {
    /**
     * 文档
     */
    DOC(3),
    /**
     * 表格
     */
    SHEET(4),
    /**
     * 智能表格
     *
     * @since 1.2.8
     */
    SMART_SHEET(10);

    private final int type;

    DocType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DocType.
     *
     * @param type the type
     * @return the moment task type
     */
    @JsonCreator
    public static DocType deserialize(int type) {
        return Arrays.stream(DocType.values())
                .filter(billType -> billType.type == type)
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
