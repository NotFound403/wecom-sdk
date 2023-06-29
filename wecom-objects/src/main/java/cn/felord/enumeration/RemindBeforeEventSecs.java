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
 * 日程提醒
 *
 * @author felord.cn
 * @since 1.0.0
 */
public enum RemindBeforeEventSecs {


    /**
     * Start remind before event secs.
     */
    START(0),
    /**
     * Five min remind before event secs.
     */
    FIVE_MIN(300),
    /**
     * Fifteen min remind before event secs.
     */
    FIFTEEN_MIN(900),
    /**
     * One hour remind before event secs.
     */
    ONE_HOUR(3600),
    /**
     * One day remind before event secs.
     */
    ONE_DAY(86400);

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
