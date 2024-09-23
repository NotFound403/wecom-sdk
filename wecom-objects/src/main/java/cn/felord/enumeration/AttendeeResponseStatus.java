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
 * 日程参与者的接受状态
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum AttendeeResponseStatus {

    /**
     * 未处理
     */
    UNDO(0),
    /**
     * 待定
     */
    UNDETERMINED(1),
    /**
     * 全部接受
     */
    ALL_ACCEPTED(2),
    /**
     * 仅接受一次
     */
    ONCE(3),
    /**
     * 拒绝
     */
    REFUSED(4);

    private final int status;

    AttendeeResponseStatus(int status) {
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
    public static AttendeeResponseStatus deserialize(int status) {
        return Arrays.stream(AttendeeResponseStatus.values())
                .filter(responseStatus -> responseStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
