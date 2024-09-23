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
 * The enum CheckboxMode
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum CheckboxMode {

    /**
     * Single checkbox mode.
     */
    SINGLE(0),

    /**
     * Multi checkbox mode.
     */
    MULTI(1);

    private final int mode;

    CheckboxMode(int mode) {
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
     * Deserialize CheckboxMode
     *
     * @param mode the mode
     * @return the schedule op mode
     */
    @JsonCreator
    public static CheckboxMode deserialize(int mode) {
        return Arrays.stream(CheckboxMode.values())
                .filter(checkboxMode -> checkboxMode.mode == mode)
                .findFirst()
                .orElse(null);
    }
}
