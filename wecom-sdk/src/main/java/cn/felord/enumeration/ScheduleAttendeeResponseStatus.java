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
 * The MomentTaskPubStatus
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum ScheduleAttendeeResponseStatus {

    /**
     * Untreated schedule attendee response status.
     */
    UNTREATED(0),
    /**
     * Cancel schedule attendee response status.
     */
    CANCEL(1),
    /**
     * All schedule attendee response status.
     */
    ALL(2),
    /**
     * Once schedule attendee response status.
     */
    ONCE(3),
    /**
     * Refused schedule attendee response status.
     */
    REFUSED(4),
    ;

    private final int status;

    ScheduleAttendeeResponseStatus(int status) {
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
     * Deserialize moment task status.
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static ScheduleAttendeeResponseStatus deserialize(int status) {
        return Arrays.stream(ScheduleAttendeeResponseStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
