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
 * The KfStopType.
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum KfStopType {
    /**
     * 停止接待
     */
    STOP(0),
    /**
     * 暂时挂起
     */
    PAUSE(1);

    private final int type;

    KfStopType(int type) {
        this.type = type;
    }

    /**
     * Deserialize KfStopType.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static KfStopType deserialize(int type) {
        return Arrays.stream(KfStopType.values())
                .filter(stopType -> stopType.type == type)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }
}
