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
 * 提醒时间与日程开始时间（start_time）的差值
 *
 * @author dax
 * @since 2024/8/6
 */
public enum RemindTimeDiff {

    /**
     * 事件开始时
     */
    BEGINNING(0),
    /**
     * 事件开始前5分钟
     */
    FIVE_MIN(300),
    /**
     * 事件开始前15分钟
     */
    FIFTEEN_MIN(900),
    /**
     * 事件开始前1小时
     */
    ONE_HOUR(3600),
    /**
     * 事件开始前1天
     */
    ONE_DAY(86400),
    /**
     * 当is_whole_day=1时，事件开始当天（09：00）
     */
    NINE_AM_ALL(86400),
    /**
     * 当is_whole_day=1时，事件开始前两天
     */
    TWO_DAY_ALL(86400),
    /**
     * 当is_whole_day=1时，事件开始前1周
     */
    ONE_WEEK_ALL(86400);

    private final int duration;

    RemindTimeDiff(int duration) {
        this.duration = duration;
    }

    /**
     * Deserialize RemindTimeDiffs
     *
     * @param duration the duration
     * @return RemindTimeDiffs remind time diffs
     */
    @JsonCreator
    public static RemindTimeDiff deserialize(int duration) {
        return Arrays.stream(RemindTimeDiff.values())
                .filter(responseduration -> responseduration.duration == duration)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    @JsonValue
    public int getDuration() {
        return duration;
    }
}
