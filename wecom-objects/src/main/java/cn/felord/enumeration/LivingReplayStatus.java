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
 * 直播回放状态
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum LivingReplayStatus {

    /**
     * 生成成功
     */
    SUCCESS(0),
    /**
     * 生成中
     */
    GENERATING(1),
    /**
     * 已删除
     */
    DELETED(2),
    /**
     * 生成失败
     */
    FAILED(3);

    private final int status;

    LivingReplayStatus(int status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize AttendeeResponseStatus
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static LivingReplayStatus deserialize(int status) {
        return Arrays.stream(LivingReplayStatus.values())
                .filter(responseStatus -> responseStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
