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
 * The TradeState
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum TradeState {
    /**
     * 已完成
     */
    FINISHED(1),
    /**
     * 已完成有退款
     */
    FINISHED_WITH_REFUND(3);

    private final int state;

    TradeState(int state) {
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
     * Deserialize moment task state.
     *
     * @param state the state
     * @return the moment task state
     */
    @JsonCreator
    public static TradeState deserialize(int state) {
        return Arrays.stream(TradeState.values())
                .filter(tradeState -> tradeState.state == state)
                .findFirst()
                .orElse(null);
    }
}
