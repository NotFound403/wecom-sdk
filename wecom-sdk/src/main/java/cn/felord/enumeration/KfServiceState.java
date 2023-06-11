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
 * The enum Kf service state.
 *
 * @author dax
 * @since 2021/9/30 13:41
 */
public enum KfServiceState {

    /**
     * Untreated kf service state.
     */
    UNTREATED(0),
    SMART_ASSISTANT(1),
    /**
     * Line up kf service state.
     */
    LINE_UP(2),
    /**
     * Manual kf service state.
     */
    MANUAL(3),
    /**
     * Finished or not started kf service state.
     */
    FINISHED_OR_NOT_STARTED(4);

    private final int state;

    KfServiceState(int state) {
        this.state = state;
    }


    /**
     * Gets state.
     *
     * @return the state
     */
    @JsonValue
    public int getState() {
        return state;
    }

    /**
     * Deserialize kf service state.
     *
     * @param state the state
     * @return the kf service state
     */
    @JsonCreator
    public static KfServiceState deserialize(int state) {
        return Arrays.stream(KfServiceState.values())
                .filter(contactType -> contactType.state == state)
                .findFirst()
                .orElse(null);
    }
}
