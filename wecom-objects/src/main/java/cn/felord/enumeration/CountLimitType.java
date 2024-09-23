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
 * 数量限制类型
 *
 * @author dax
 * @since 2024/8/5
 */
public enum CountLimitType {

    /**
     * 等于count数量
     * <p>
     * count = [1,9]
     */
    EQ(0),
    /**
     * 小于等于count数量
     * <p>
     * count = [1,9]
     */
    LTE(1);

    private final int type;

    CountLimitType(int type) {
        this.type = type;
    }

    /**
     * Deserialize CountLimitType.
     *
     * @param type the type
     * @return the contact type
     */
    @JsonCreator
    public static CountLimitType deserialize(int type) {
        return Arrays.stream(CountLimitType.values())
                .filter(countLimitType -> countLimitType.type == type)
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
