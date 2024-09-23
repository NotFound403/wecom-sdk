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
 * 用户类型
 *
 * @author felord.cn
 * @since 1.1.3
 */
public enum UseType {

    /**
     * 客户
     */
    EX_USER(1),
    /**
     * 企业互联
     */
    CORP_LINK(2),
    /**
     * 上下游
     */
    CORP_GROUP(3),
    /**
     * 互联企业（圈子）
     */
    CORP_CONNECTED(4);

    private final int type;

    UseType(int type) {
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
     * Deserialize user type.
     *
     * @param type the type
     * @return the business type
     */
    @JsonCreator
    public static UseType deserialize(int type) {
        return Arrays.stream(UseType.values())
                .filter(boolEnum -> boolEnum.type == type)
                .findFirst()
                .orElse(null);
    }
}
