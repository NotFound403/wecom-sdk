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
 * 菜单类型
 *
 * @author dax
 * @since 2024/5/25 16:19
 */
public enum MsgMenuContentType {

    /**
     * 回复菜单
     */
    CLICK("click"),

    /**
     * 超链接菜单
     */
    VIEW("view"),

    /**
     * 小程序菜单
     */
    MINIPROGRAM("miniprogram"),

    /**
     * 文本
     */
    TEXT("text");
    private final String type;

    MsgMenuContentType(String type) {
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
     * Deserialize MsgMenuContentType.
     *
     * @param type the type
     * @return the MsgMenuContentType
     */
    @JsonCreator
    public static MsgMenuContentType deserialize(String type) {
        return Arrays.stream(MsgMenuContentType.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
