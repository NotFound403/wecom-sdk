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

/**
 * The type BookingInfoRequest.
 *
 * @author dax
 * @since 2024/11/29
 */
@ToString
@Getter
public class BookingInfoRequest {
    private Integer meetingroomId;
    private Instant startTime;
    private Instant endTime;
    private String city;
    private String building;
    private String floor;

    public BookingInfoRequest meetingroomId(int meetingroomId) {
        this.meetingroomId = meetingroomId;
        return this;
    }

    public BookingInfoRequest startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public BookingInfoRequest endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public BookingInfoRequest city(String city) {
        this.city = city;
        return this;
    }

    public BookingInfoRequest building(String building) {
        this.building = building;
        return this;
    }

    public BookingInfoRequest floor(String floor) {
        this.floor = floor;
        return this;
    }
}
