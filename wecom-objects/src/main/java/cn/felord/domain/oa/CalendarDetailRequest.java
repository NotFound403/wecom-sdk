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
 * The type Calendar detail request.
 *
 * @author dax
 * @since 2024/5/24 11:10
 */
@ToString
@Getter
public class CalendarDetailRequest {
    private final Set<String> calIdList;

    /**
     * Instantiates a new Calendar detail request.
     *
     * @param calIdList the cal id list
     */
    CalendarDetailRequest(Set<String> calIdList) {
        this.calIdList = calIdList;
    }

    /**
     * From calendar detail request.
     *
     * @param calId the cal id
     * @return the calendar detail request
     */
    public static CalendarDetailRequest from(String calId) {
        return from(Collections.singleton(calId));
    }

    /**
     * From calendar detail request.
     *
     * @param calIdList the cal id list
     * @return the calendar detail request
     */
    public static CalendarDetailRequest from(Set<String> calIdList) {
        return new CalendarDetailRequest(calIdList);
    }
}
