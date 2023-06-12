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
 * The enum Fill out auth.
 *
 * @author dax
 * @since 2023 /3/13 17:05
 */
public enum FillOutAuth {

    /**
     * All fill out auth.
     */
    ALL(0),

    /**
     * Staff or dept fill out auth.
     */
    STAFF_OR_DEPT(1),
    /**
     * School fill out auth.
     */
    SCHOOL(4);

    private final int type;

    FillOutAuth(int type) {
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
     * Deserialize fill out auth.
     *
     * @param type the type
     * @return the fill out auth
     */
    @JsonCreator
    public static FillOutAuth deserialize(int type) {
        return Arrays.stream(FillOutAuth.values())
                .filter(fillOutAuth -> fillOutAuth.type == type)
                .findFirst()
                .orElse(null);
    }

}
