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
 * The enum Date ctrl type.
 *
 * @author dax
 * @since 2024/5/25 16:19
 */
public enum SelectType {


    /**
     * Single selector ctrl type.
     */
    SINGLE("single"),

    /**
     * Multi selector ctrl type.
     */
    MULTI("multi");
    private final String type;

    SelectType(String type) {
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
     * Deserialize SingleOrMulti.
     *
     * @param type the type
     * @return the SingleOrMulti
     */
    @JsonCreator
    public static SelectType deserialize(String type) {
        return Arrays.stream(SelectType.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
