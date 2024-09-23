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
import java.util.Objects;

/**
 * The enum Chat type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ChatType {
    /**
     * 客户群发
     */
    SINGLE("single"),
    /**
     * 客户群群发
     */
    GROUP("group");

    private final String type;

    ChatType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }

    /**
     * Deserialize chat type.
     *
     * @param type the type
     * @return the chat type
     */
    @JsonCreator
    public static ChatType deserialize(String type) {
        return Arrays.stream(ChatType.values())
                .filter(contactType -> Objects.equals(type,contactType.type))
                .findFirst()
                .orElse(null);
    }

}
