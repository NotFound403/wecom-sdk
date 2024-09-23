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
 * 设备来源
 *
 * @author dax
 * @since 2024/5/25 16:19
 */
public enum DeviceSourceType {

    /**
     * 未知
     */
    UNKNOWN(0),

    /**
     * 成员确认
     */
    MEMBER_ACK(1),

    /**
     * 管理员导入
     */
    IMPORT_VIA_ADMIN(2),

    /**
     * 成员自主申报
     */
    SELF_APPLY(3);

    private final int type;

    DeviceSourceType(int type) {
        this.type = type;
    }

    /**
     * Deserialize device source type.
     *
     * @param type the type
     * @return the device source type
     */
    @JsonCreator
    public static DeviceSourceType deserialize(int type) {
        return Arrays.stream(DeviceSourceType.values())
                .filter(deviceSourceType -> deviceSourceType.type == type)
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
