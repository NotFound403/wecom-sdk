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
 * The MediaJobStatus
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum MediaJobStatus {

    /**
     * 处理中
     */
    DOING(1),

    /**
     * 完成
     */
    DONE(2),
    /**
     * 异常失败
     */
    FAIL(3);

    private final int status;

    MediaJobStatus(int status) {
        this.status = status;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize button type.
     *
     * @param status the status
     * @return the button type
     */
    @JsonCreator
    public static MediaJobStatus deserialize(int status) {
        return Arrays.stream(MediaJobStatus.values())
                .filter(answerStatus -> answerStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
