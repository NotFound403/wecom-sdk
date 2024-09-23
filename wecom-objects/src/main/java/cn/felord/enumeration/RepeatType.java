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
 * 重复类型
 *
 * @author felord.cn
 * @since 1.0.0
 */
public enum RepeatType {

    /**
     * Each day repeat type.
     */
    EACH_DAY(0),
    /**
     * Each week repeat type.
     */
    EACH_WEEK(1),
    /**
     * Each month repeat type.
     */
    EACH_MONTH(2),
    /**
     * Each year repeat type.
     */
    EACH_YEAR(5),
    /**
     * Work day repeat type.
     */
    WORK_DAY(7);

    private final int type;

    RepeatType(int type) {
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
    public static RepeatType deserialize(int type) {
        return Arrays.stream(RepeatType.values())
                .filter(boolEnum -> boolEnum.type == type)
                .findFirst()
                .orElse(null);
    }
}
