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
 * 设备导入结果
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum DeviceStatus {

    /**
     * 成功
     */
    SUCCESS(1),
    /**
     * 重复导入
     */
    DUPLICATE(2),
    /**
     * 不支持的设备
     */
    UNSUPPORTED(3),
    /**
     * 数据格式错误
     */
    INCORRECT(4);

    private final int type;

    DeviceStatus(int type) {
        this.type = type;
    }

    /**
     * Deserialize device status.
     *
     * @param type the type
     * @return the device status
     */
    @JsonCreator
    public static DeviceStatus deserialize(int type) {
        return Arrays.stream(DeviceStatus.values())
                .filter(deviceStatus -> deviceStatus.type == type)
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
