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
 * The enum Kf service state.
 *
 * @author dax
 * @since 2021 /9/30 13:41
 */
public enum KfServiceState {

    /**
     * 未处理
     */
    UNTREATED(0),
    /**
     * 由智能助手接待
     */
    SMART_ASSISTANT(1),
    /**
     * 待接入池排队中
     */
    LINE_UP(2),
    /**
     * 由人工接待
     */
    MANUAL(3),
    /**
     * 已结束/未开始
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
