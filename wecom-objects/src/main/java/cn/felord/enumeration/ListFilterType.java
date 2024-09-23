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
 * The enum Moment list filter type.
 *
 * @author dax
 * @since 2021/9/19 19:47
 */
public enum ListFilterType {
    /**
     * Corp moment list filter type.
     */
    CORP(0),
    /**
     * Personal moment list filter type.
     */
    PERSONAL(1),
    /**
     * Whole moment list filter type.
     */
    WHOLE(2);

    private final int type;

    ListFilterType(int type) {
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
     * Deserialize moment list filter type.
     *
     * @param type the type
     * @return the moment list filter type
     */
    @JsonCreator
    public static ListFilterType deserialize(int type) {
        return Arrays.stream(ListFilterType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
