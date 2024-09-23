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
 * The enum Moment visible type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum MomentVisibleType {
    /**
     * Partial moment visible type.
     */
    PARTIAL(0),
    /**
     * Whole moment visible type.
     */
    WHOLE(1);

    private final int type;

    MomentVisibleType(int type) {
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
     * Deserialize moment visible type.
     *
     * @param type the type
     * @return the moment visible type
     */
    @JsonCreator
    public static MomentVisibleType deserialize(int type) {
        return Arrays.stream(MomentVisibleType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
