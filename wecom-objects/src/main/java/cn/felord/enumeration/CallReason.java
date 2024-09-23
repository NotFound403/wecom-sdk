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
 * The enum CallReason
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum CallReason {

    /**
     * Ringing call reason.
     */
    RINGING(1),
    /**
     * Answered call reason.
     */
    ANSWERED(2),
    /**
     * In call call reason.
     */
    IN_CALL(3),
    /**
     * Call timeout user hung up call reason.
     */
    CALL_TIMEOUT_USER_HUNG_UP(4),
    /**
     * Out of service area call reason.
     */
    OUT_OF_SERVICE_AREA(5),
    /**
     * Unanswered due to unpaid bills call reason.
     */
    UNANSWERED_DUE_TO_UNPAID_BILLS(6),
    /**
     * Rejected by called party call reason.
     */
    REJECTED_BY_CALLED_PARTY(7),
    /**
     * Called party phone off call reason.
     */
    CALLED_PARTY_PHONE_OFF(8),
    /**
     * Invalid number call reason.
     */
    INVALID_NUMBER(9),
    /**
     * Call restricted call reason.
     */
    CALL_RESTRICTED(10),
    /**
     * Line error call reason.
     */
    LINE_ERROR(11),
    /**
     * Call timeout system hung up call reason.
     */
    CALL_TIMEOUT_SYSTEM_HUNG_UP(12),
    /**
     * Exceeded call limit call reason.
     */
    EXCEEDED_CALL_LIMIT(13),
    /**
     * Line timeout without response call reason.
     */
    LINE_TIMEOUT_WITHOUT_RESPONSE(14),
    /**
     * Exceeded limit call reason.
     */
    EXCEEDED_LIMIT(15),
    /**
     * Line busy please redial later call reason.
     */
    LINE_BUSY_PLEASE_REDIAL_LATER(16),
    /**
     * Call cancelled notification call reason.
     */
    CALL_CANCELLED_NOTIFICATION(17),
    /**
     * Call timeout without confirmation call reason.
     */
    CALL_TIMEOUT_WITHOUT_CONFIRMATION(20),
    /**
     * Other call reason.
     */
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
     * Deserialize CallReason
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static CallReason deserialize(int type) {
        return Arrays.stream(CallReason.values())
                .filter(callReason -> callReason.type == type)
                .findFirst()
                .orElse(null);
    }
}
