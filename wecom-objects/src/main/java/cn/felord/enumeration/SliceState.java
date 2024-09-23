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
 * 时长计算来源类型
 *
 * @author dax
 * @since 2024/12/19
 */
public enum SliceState {
    /**
     * 系统自动计算
     */
    SYS(1),
    /**
     * 用户修改
     */
    SELF(2);

    private final int state;

    SliceState(int state) {
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
     * Deserialize slice state.
     *
     * @param state the state
     * @return the slice state
     */
    @JsonCreator
    public static SliceState deserialize(int state) {
        return Arrays.stream(SliceState.values())
                .filter(sliceState -> sliceState.state == state)
                .findFirst()
                .orElse(null);
    }
}
