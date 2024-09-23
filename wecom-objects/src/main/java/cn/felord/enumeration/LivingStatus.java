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
 * 直播的状态
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum LivingStatus {

    /**
     * 预约中
     */
    BOOKING(0),
    /**
     * 直播中
     */
    LIVING(1),
    /**
     * 已结束
     */
    ENDED(2),
    /**
     * 已过期
     */
    EXPIRED(3),
    /**
     * 已取消
     */
    CANCELED(4);

    private final int status;

    LivingStatus(int status) {
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
    public static LivingStatus deserialize(int status) {
        return Arrays.stream(LivingStatus.values())
                .filter(responseStatus -> responseStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
