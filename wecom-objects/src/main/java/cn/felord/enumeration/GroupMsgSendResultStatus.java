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
 * The enum GroupMsgSendResultStatus
 *
 * @author dax
 * @since 2021 /4/18 10:47
 */
public enum GroupMsgSendResultStatus {

    /**
     * Unsent msg send status.
     */
    UNSENT(0),
    /**
     * Sent msg send status.
     */
    SENT(1),
    /**
     * Fail due to non friend group msg send result status.
     */
    FAIL_DUE_TO_NON_FRIEND(2),
    /**
     * Has received other msg group msg send result status.
     */
    HAS_RECEIVED_OTHER_MSG(3);

    private final int status;

    GroupMsgSendResultStatus(int status) {
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
     * Deserialize GroupMsgSendResultStatus
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static GroupMsgSendResultStatus deserialize(int status) {
        return Arrays.stream(GroupMsgSendResultStatus.values())
                .filter(sendResultStatus -> sendResultStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
