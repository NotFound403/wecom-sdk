/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
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
public enum CallReason {

    RINGING(1),
    ANSWERED(2),
    IN_CALL(3),
    CALL_TIMEOUT_USER_HUNG_UP(4),
    OUT_OF_SERVICE_AREA(5),
    UNANSWERED_DUE_TO_UNPAID_BILLS(6),
    REJECTED_BY_CALLED_PARTY(7),
    CALLED_PARTY_PHONE_OFF(8),
    INVALID_NUMBER(9),
    CALL_RESTRICTED(10),
    LINE_ERROR(11),
    CALL_TIMEOUT_SYSTEM_HUNG_UP(12),
    EXCEEDED_CALL_LIMIT(13),
    LINE_TIMEOUT_WITHOUT_RESPONSE(14),
    EXCEEDED_LIMIT(15),
    LINE_BUSY_PLEASE_REDIAL_LATER(16),
    CALL_CANCELLED_NOTIFICATION(17),
    CALL_TIMEOUT_WITHOUT_CONFIRMATION(20),
    OTHER(99);

    private final int type;

    CallReason(int type) {
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
    public static CallReason deserialize(int type) {
        return Arrays.stream(CallReason.values())
                .filter(contactScene -> contactScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
