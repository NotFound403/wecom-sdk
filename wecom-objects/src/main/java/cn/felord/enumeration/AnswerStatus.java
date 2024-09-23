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
 * The AnswerStatus
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum AnswerStatus {

    /**
     * Normal form item status.
     */
    NORMAL(1),

    /**
     * Deleted form item status.
     */
    DELETED(2),
    /**
     * Invalid answer status.
     */
    INVALID(3);

    private final int type;

    AnswerStatus(int type) {
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
     * Deserialize AnswerStatus.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static AnswerStatus deserialize(int type) {
        return Arrays.stream(AnswerStatus.values())
                .filter(answerStatus -> answerStatus.type == type)
                .findFirst()
                .orElse(null);
    }
}
