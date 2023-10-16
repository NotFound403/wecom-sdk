/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 联系人身份类型
 *
 * @author felord.cn
 * @since 1.1.3
 */
public enum IdentityType {

    /**
     * 成员
     */
    MEMBER(1),
    /**
     * 负责人
     */
    HEAD(2);

    private final int type;

    IdentityType(int type) {
        this.type = type;
    }

    /**
     * Deserialize IdentityType
     *
     * @param type the type
     * @return the business type
     */
    @JsonCreator
    public static IdentityType deserialize(int type) {
        return Arrays.stream(IdentityType.values())
                .filter(identityType -> identityType.type == type)
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
