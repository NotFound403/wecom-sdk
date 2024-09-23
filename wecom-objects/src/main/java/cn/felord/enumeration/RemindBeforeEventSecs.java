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
 * 日程提醒
 *
 * @author felord.cn
 * @since 1.0.0
 */
public enum RemindBeforeEventSecs {


    /**
     * 事件开始时
     */
    START(0),
    /**
     * 事件开始前5分钟
     */
    MIN_5(300),
    /**
     * 事件开始前15分钟
     */
    MIN_15(900),
    /**
     * 事件开始前1小时
     */
    MIN_60(3600),
    /**
     * 事件开始前1天
     */
    MIN_1440(86400);

    private final int sec;

    RemindBeforeEventSecs(int sec) {
        this.sec = sec;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getsec() {
        return sec;
    }

    /**
     * Deserialize bool enum.
     *
     * @param sec the sec
     * @return the bool enum
     */
    @JsonCreator
    public static RemindBeforeEventSecs deserialize(int sec) {
        return Arrays.stream(RemindBeforeEventSecs.values())
                .filter(boolEnum -> boolEnum.sec == sec)
                .findFirst()
                .orElse(null);
    }
}
