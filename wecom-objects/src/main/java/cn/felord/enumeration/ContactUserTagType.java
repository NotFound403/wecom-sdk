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
 * The enum Contact user tag type.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum ContactUserTagType {
    /**
     * Corp settings contact user tag type.
     */
    CORP_SETTINGS(1),
    /**
     * Custom contact user tag type.
     */
    CUSTOM(2),
    /**
     * Rule group contact user tag type.
     */
    RULE_GROUP(3);

    private final int type;

    ContactUserTagType(int type) {
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
     * Deserialize contact user tag type.
     *
     * @param type the type
     * @return the contact user tag type
     */
    @JsonCreator
    public static ContactUserTagType deserialize(int type) {
        return Arrays.stream(ContactUserTagType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
