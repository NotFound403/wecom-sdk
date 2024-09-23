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
 * 日期类型
 *
 * @author dax
 * @since 2024/8/4 14:28
 */
public enum DurationDateType {
    /**
     * 自然日
     */
    NATURAL_DAY(1),
    /**
     * 工作日（跳过双休和法定节假日）
     */
    WORK_DAY(2);

    private final int type;

    DurationDateType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DurationDateType
     *
     * @param type the type
     * @return the DurationDateType
     */
    @JsonCreator
    public static DurationDateType deserialize(int type) {
        return Arrays.stream(DurationDateType.values())
                .filter(durationDateType -> durationDateType.type == type)
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
