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

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;

/**
 * The type Schedule detail request.
 *
 * @author dax
 * @since 2024/10/5
 */
@ToString
@Getter
public class ScheduleDetailRequest {
    private final Set<String> scheduleIdList;

    /**
     * Instantiates a new Schedule detail request.
     *
     * @param scheduleIdList the schedule id list
     */
    ScheduleDetailRequest(Set<String> scheduleIdList) {
        this.scheduleIdList = scheduleIdList;
    }

    /**
     * From schedule detail request.
     *
     * @param scheduleId the schedule id
     * @return the schedule detail request
     */
    public static ScheduleDetailRequest from(String scheduleId) {
        return from(Collections.singleton(scheduleId));
    }

    /**
     * From schedule detail request.
     *
     * @param scheduleIdList the schedule id list
     * @return the schedule detail request
     */
    public static ScheduleDetailRequest from(Set<String> scheduleIdList) {
        return new ScheduleDetailRequest(scheduleIdList);
    }

}
