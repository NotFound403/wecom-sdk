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
 * The enum Time format type.
 *
 * @author dax
 * @since 2024/8/4 14:28
 */
public enum TimeFormatType {
    /**
     * 时分
     */
    HM(0),
    /**
     * 时分秒
     */
    HMS(1);

    private final int type;

    TimeFormatType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DateFormatType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static TimeFormatType deserialize(int type) {
        return Arrays.stream(TimeFormatType.values())
                .filter(dateFormatType -> dateFormatType.type == type)
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
