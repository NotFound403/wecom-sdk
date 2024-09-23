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

package cn.felord.domain.checkin;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * The type Punch correction request.
 */
@ToString
@Getter
public class PunchCorrectionRequest {
    private final String userid;
    private final Instant scheduleDateTime;
    private final Instant checkinTime;
    private final Integer scheduleCheckinTime;
    private final String remark;

    /**
     * Instantiates a new Punch correction request.
     *
     * @param userid           the userid
     * @param scheduleDateTime the schedule date time
     * @param checkinTime      the checkin time
     */
    public PunchCorrectionRequest(String userid, Instant scheduleDateTime, Instant checkinTime) {
        this(userid, scheduleDateTime, checkinTime, null);
    }


    /**
     * Instantiates a new Punch correction request.
     *
     * @param userid              the userid
     * @param scheduleDateTime    the schedule date time
     * @param checkinTime         the checkin time
     * @param scheduleCheckinTime the schedule checkin time
     */
    public PunchCorrectionRequest(String userid, Instant scheduleDateTime, Instant checkinTime, Integer scheduleCheckinTime) {
        this(userid, scheduleDateTime, checkinTime, scheduleCheckinTime, null);
    }

    /**
     * Instantiates a new Punch correction request.
     *
     * @param userid              the userid
     * @param scheduleDateTime    the schedule date time
     * @param checkinTime         the checkin time
     * @param scheduleCheckinTime the schedule checkin time
     * @param remark              the remark
     */
    public PunchCorrectionRequest(String userid, Instant scheduleDateTime, Instant checkinTime, Integer scheduleCheckinTime, String remark) {
        this.userid = userid;
        this.scheduleDateTime = scheduleDateTime;
        this.checkinTime = checkinTime;
        this.scheduleCheckinTime = scheduleCheckinTime;
        this.remark = remark;
    }
}
