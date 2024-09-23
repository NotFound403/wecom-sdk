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
 * The enum Checkin type.
 *
 * @author dax
 * @since 2024/9/25
 */
public enum CheckinType {
    /**
     * 手机
     */
    MOBILE(0),
    /**
     * 智慧考勤机
     */
    SMART(2),
    /**
     * 手机和智慧考勤机
     */
    BOTH(3);

    private final int type;

    CheckinType(int type) {
        this.type = type;
    }

    /**
     * Deserialize checkinType
     *
     * @param type the type
     * @return the checkin data type
     */
    @JsonCreator
    public static CheckinType deserialize(int type) {
        return Arrays.stream(CheckinType.values())
                .filter(checkinType -> checkinType.type == type)
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
