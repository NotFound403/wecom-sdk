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
 * 操作来源
 *
 * @author dax
 * @since 2024/10/9
 */
public enum OptSource {

    /**
     * 聊天
     */
    CHAT(401),

    /**
     * 邮件
     */
    EMAIL(1),
    /**
     * 文档
     */
    DOC(1),
    /**
     * 微盘
     */
    WE_DRIVE(1),
    /**
     * 日程
     */
    SCHEDULE(2);

    private final int source;

    OptSource(int source) {
        this.source = source;
    }

    /**
     * Deserialize opt source.
     *
     * @param source the source
     * @return the opt source
     */
    @JsonCreator
    public static OptSource deserialize(int source) {
        return Arrays.stream(OptSource.values())
                .filter(optSource -> optSource.source == source)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets source.
     *
     * @return the source
     */
    @JsonValue
    public int getSource() {
        return source;
    }
}
