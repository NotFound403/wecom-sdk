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
 * The enum Schedule op mode.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum ScheduleOpMode {
    /**
     * All schedule op mode.
     */
    ALL(0),
    /**
     * This schedule op mode.
     */
    THIS(1),
    /**
     * Future schedule op mode.
     */
    FUTURE(2);

    private final int mode;

    ScheduleOpMode(int mode) {
        this.mode = mode;
    }

    /**
     * Gets mode.
     *
     * @return the mode
     */
    @JsonValue
    public int getMode() {
        return mode;
    }

    /**
     * Deserialize schedule op mode.
     *
     * @param mode the mode
     * @return the schedule op mode
     */
    @JsonCreator
    public static ScheduleOpMode deserialize(int mode) {
        return Arrays.stream(ScheduleOpMode.values())
                .filter(contactScene -> contactScene.mode == mode)
                .findFirst()
                .orElse(null);
    }
}
