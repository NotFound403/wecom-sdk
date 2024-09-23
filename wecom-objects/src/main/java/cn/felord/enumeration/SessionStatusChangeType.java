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
 * The enum Button type.
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum SessionStatusChangeType {
    /**
     * 从接待池接入会话
     */
    FROM_POOL(1),
    /**
     * 转接会话
     */
    TRANSFER(2),
    /**
     * 结束会话
     */
    OVER(3),
    /**
     * 重新接入已结束/已转接会话
     */
    RE_ENTRY(4);

    private final int type;

    SessionStatusChangeType(int type) {
        this.type = type;
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

    /**
     * Deserialize button type.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static SessionStatusChangeType deserialize(int type) {
        return Arrays.stream(SessionStatusChangeType.values())
                .filter(changeType -> changeType.type == type)
                .findFirst()
                .orElse(null);
    }
}
