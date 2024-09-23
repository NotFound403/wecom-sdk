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

package cn.felord.domain.externalcontact;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 19:06
 */
@ToString
@Getter
public class UserBehaviorDataRequest {
    private final Instant startTime;
    private final Instant endTime;
    private final List<String> userid;
    private final List<Long> partyid;

    public UserBehaviorDataRequest(List<String> userid, Instant startTime, Instant endTime) {
        this(startTime, endTime, userid, Collections.emptyList());
    }

    public UserBehaviorDataRequest(Instant startTime, Instant endTime, List<Long> partyid) {
        this(startTime, endTime, Collections.emptyList(), partyid);
    }

    public UserBehaviorDataRequest(Instant startTime, Instant endTime, List<String> userid, List<Long> partyid) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.userid = userid;
        this.partyid = partyid;
    }
}
