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
 * The enum GroupChatStatus.
 *
 * @author dax
 * @since 2021/9/14 14:44
 */
public enum GroupChatStatus {

    /**
     * Normal group chat status.
     */
    NORMAL(0),

    /**
     * Waiting group chat status.
     */
    WAITING(1),

    /**
     * Pending group chat status.
     */
    PENDING(2),

    /**
     * Finished group chat status.
     */
    FINISHED(3);

    private final int status;

    GroupChatStatus(int status) {
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
     * Deserialize GroupChatStatus.
     *
     * @param status the status
     * @return the takeover status
     */
    @JsonCreator
    public static GroupChatStatus deserialize(int status) {
        return Arrays.stream(GroupChatStatus.values())
                .filter(groupChatStatus -> groupChatStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
