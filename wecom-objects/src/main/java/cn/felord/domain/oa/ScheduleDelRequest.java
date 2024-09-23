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

package cn.felord.domain.oa;

import cn.felord.enumeration.ScheduleOpMode;
import lombok.Getter;

import java.time.Instant;

/**
 * The type Schedule del request.
 *
 * @author felord.cn
 * @since 1.0.0
 */
@Getter
public class ScheduleDelRequest {
    private final String scheduleId;
    private final ScheduleOpMode opMode;
    private final Instant opStartTime;

    /**
     * Instantiates a new Schedule del request.
     *
     * @param scheduleId the schedule id
     */
    public ScheduleDelRequest(String scheduleId) {
        this(scheduleId, null, null);
    }

    /**
     * Instantiates a new Schedule del request.
     *
     * @param scheduleId the schedule id
     * @param opMode     the op mode
     */
    public ScheduleDelRequest(String scheduleId, ScheduleOpMode opMode) {
        this(scheduleId, opMode, null);
    }

    /**
     * Instantiates a new Schedule del request.
     *
     * @param scheduleId  the schedule id
     * @param opStartTime the op start time
     */
    public ScheduleDelRequest(String scheduleId, Instant opStartTime) {
        this(scheduleId, null, opStartTime);
    }

    /**
     * Instantiates a new Schedule del request.
     *
     * @param scheduleId  the schedule id
     * @param opMode      the op mode
     * @param opStartTime the op start time
     */
    public ScheduleDelRequest(String scheduleId, ScheduleOpMode opMode, Instant opStartTime) {
        this.scheduleId = scheduleId;
        this.opMode = opMode;
        this.opStartTime = opStartTime;
    }
}
