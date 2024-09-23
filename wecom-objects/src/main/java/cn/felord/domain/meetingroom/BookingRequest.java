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

import java.time.Instant;
import java.util.List;

/**
 * The type BookRequest.
 *
 * @author dax
 * @since 2021 /7/12 19:23
 */
@ToString
@Getter
public class BookingRequest {
    private final Integer meetingroomId;
    private final Instant startTime;
    private final Instant endTime;
    private final String booker;
    private String subject;
    private List<String> attendees;

    /**
     * Instantiates a new Booking request.
     *
     * @param meetingroomId the meetingroom id
     * @param startTime     the start time
     * @param endTime       the end time
     * @param booker        the booker
     * @param attendees     the attendees
     */
    public BookingRequest(int meetingroomId, Instant startTime, Instant endTime, String booker, List<String> attendees) {
        this.meetingroomId = meetingroomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.booker = booker;
        this.attendees = attendees;
    }

    /**
     * Instantiates a new Booking request.
     *
     * @param meetingroomId the meetingroom id
     * @param startTime     the start time
     * @param endTime       the end time
     * @param booker        the booker
     * @param subject       the subject
     */
    public BookingRequest(int meetingroomId, Instant startTime, Instant endTime, String booker, String subject) {
        this.meetingroomId = meetingroomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.booker = booker;
        this.subject = subject;
    }

    /**
     * Instantiates a new Booking request.
     *
     * @param meetingroomId the meetingroom id
     * @param startTime     the start time
     * @param endTime       the end time
     * @param booker        the booker
     * @param subject       the subject
     * @param attendees     the attendees
     */
    public BookingRequest(int meetingroomId, Instant startTime, Instant endTime, String booker, String subject, List<String> attendees) {
        this.meetingroomId = meetingroomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.booker = booker;
        this.subject = subject;
        this.attendees = attendees;
    }
}
