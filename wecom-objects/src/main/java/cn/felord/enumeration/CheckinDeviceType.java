/*
 * Copyright (c) 2025. felord.cn
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
 * 打卡设备类型
 *
 * @author dax
 * @since 2025/4/27
 */
public enum CheckinDeviceType {
    /**
     * 门禁
     */
    ENTRANCE_GUARD(1),
    /**
     * 考勤机
     */
    MACHINE(2),
    /**
     * 其它
     */
    OTHERS(3);

    private final int type;

    CheckinDeviceType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static CheckinDeviceType deserialize(int type) {
        return Arrays.stream(CheckinDeviceType.values())
                .filter(checkinMethodType -> checkinMethodType.type == type)
                .findFirst()
                .orElse(null);
    }
}
