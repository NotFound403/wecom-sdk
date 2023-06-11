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
 * The enum Bool enum.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public enum BoolEnum {

    /**
     * False bool enum.
     */
    FALSE(0),
    /**
     * True bool enum.
     */
    TRUE(1);

    private final int type;

    BoolEnum(int type) {
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
     * Deserialize bool enum.
     *
     * @param type the type
     * @return the bool enum
     */
    @JsonCreator
    public static BoolEnum deserialize(int type) {
        return Arrays.stream(BoolEnum.values())
                .filter(boolEnum -> boolEnum.type==type)
                .findFirst()
                .orElse(null);
    }
}
