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
 * 可信设备类型
 *
 * @author dax
 * @since 2024/7/3 15:28
 */
public enum SecurityDeviceType {
    /**
     * 企业可信设备
     */
    ENTERPRISE(1),
    /**
     * 个人可信设备
     */
    PERSONAL(2);

    private final int type;

    SecurityDeviceType(int type) {
        this.type = type;
    }

    /**
     * Deserialize SecurityDeviceType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static SecurityDeviceType deserialize(int type) {
        return Arrays.stream(SecurityDeviceType.values())
                .filter(bankAccountType -> bankAccountType.type == type)
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
