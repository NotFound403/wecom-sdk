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
 * 重复类型
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public enum FormRepeatType {

    /**
     * Each day repeat type.
     */
    EACH_DAY(1),
    /**
     * Each week repeat type.
     */
    EACH_WEEK(0),
    /**
     * Each month repeat type.
     */
    EACH_MONTH(2);

    private final int type;

    FormRepeatType(int type) {
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
    public static FormRepeatType deserialize(int type) {
        return Arrays.stream(FormRepeatType.values())
                .filter(boolEnum -> boolEnum.type == type)
                .findFirst()
                .orElse(null);
    }
}
