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
 * The EquipmentType
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum EquipmentType {
    /**
     * 电视
     */
    TV(1),
    /**
     * 电话
     */
    PHONE(2),
    /**
     * 投影仪
     */
    PROJECTOR(3),
    /**
     * 白板
     */
    WHITEBOARD(4),
    /**
     * 视频
     */
    VIDEO(5);

    private final int type;

    EquipmentType(int type) {
        this.type = type;
    }

    /**
     * Deserialize EquipmentType
     *
     * @param type the type
     * @return the moment create type
     */
    @JsonCreator
    public static EquipmentType deserialize(int type) {
        return Arrays.stream(EquipmentType.values())
                .filter(contactType -> contactType.type == type)
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
