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
 * 设备状态
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum DeviceStatus {

    /**
     * 已导入未登录
     */
    IMPORTED_NOT_LOGIN(1),
    /**
     * 待邀请
     */
    TO_BE_INVITED(2),
    /**
     * 待管理员确认为企业设备
     */
    CORP_TO_BE_CONFIRMED(3),
    /**
     * 待管理员确认为个人设备
     */
    PERSONAL_TO_BE_CONFIRMED(4),
    /**
     * 已确认为可信企业设备
     */
    CORP_CONFIRMED(5),
    /**
     * 已确认为可信个人设备
     */
    PERSONAL_CONFIRMED(6);

    private final int type;

    DeviceStatus(int type) {
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
}
