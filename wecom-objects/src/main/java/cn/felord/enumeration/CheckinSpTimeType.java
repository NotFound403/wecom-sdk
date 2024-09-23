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
 * 打卡假勤时长单位
 *
 * @author dax
 * @since 2024/8/4 14:28
 */
public enum CheckinSpTimeType {
    /**
     * 按天
     */
    DAY(0),
    /**
     * 按小时
     */
    HOUR(1);

    private final int scale;

    CheckinSpTimeType(int scale) {
        this.scale = scale;
    }

    /**
     * Deserialize DurationScale
     *
     * @param scale the scale
     * @return the DurationScale
     */
    @JsonCreator
    public static CheckinSpTimeType deserialize(int scale) {
        return Arrays.stream(CheckinSpTimeType.values())
                .filter(durationTimeScale -> durationTimeScale.scale == scale)
                .findFirst()
                .orElse(null);
    }


    /**
     * Gets scale.
     *
     * @return the scale
     */
    @JsonValue
    public int getScale() {
        return scale;
    }

}
