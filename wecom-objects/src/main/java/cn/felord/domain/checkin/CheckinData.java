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

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CheckinData {
    private Instant checkinTime;
    private String wifiname;
    private String notes;
    private String locationDetail;
    private Integer groupid;
    private String userid;
    private String groupname;
    private String deviceid;
    private String checkinType;
    private String exceptionType;
    private String locationTitle;
    private String wifimac;
    private List<String> mediaids;
    private Integer timelineId;
    private Integer scheduleId;
    private Integer lng;
    private Integer lat;
    private Instant schCheckinTime;
}
