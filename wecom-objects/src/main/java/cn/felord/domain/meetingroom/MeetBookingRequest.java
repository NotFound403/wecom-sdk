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

package cn.felord.domain.meetingroom;

import lombok.Getter;
import lombok.ToString;

/**
 * The type MeetBookingRequest
 *
 * @author dax
 * @since 2024/11/29
 */
@ToString
@Getter
public class MeetBookingRequest {
    private final Integer meetingroomId;
    private final String meetingid;
    private final String booker;

    public MeetBookingRequest(int meetingroomId, String meetingid, String booker) {
        this.meetingroomId = meetingroomId;
        this.meetingid = meetingid;
        this.booker = booker;
    }
}
