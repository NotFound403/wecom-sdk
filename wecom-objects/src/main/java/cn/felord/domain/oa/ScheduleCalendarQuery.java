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

import lombok.Data;

/**
 * The type Calendar query.
 *
 * @author felord
 * @since 2021 /11/22 9:46
 */
@Data
public class ScheduleCalendarQuery {
    private final String calId;
    private final Integer offset;
    private final Integer limit;

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId the cal id
     */
    public ScheduleCalendarQuery(String calId) {
        this(calId, null, null);
    }

    /**
     * Instantiates a new Calendar query.
     *
     * @param offset the offset
     * @param calId  the cal id
     */
    public ScheduleCalendarQuery(int offset, String calId) {
        this(calId, offset, null);
    }

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId the cal id
     * @param limit the limit
     */
    public ScheduleCalendarQuery(String calId, int limit) {
        this(calId, null, limit);
    }

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId  the cal id
     * @param offset the offset
     * @param limit  the limit
     */
    public ScheduleCalendarQuery(String calId, Integer offset, Integer limit) {
        this.calId = calId;
        this.offset = offset;
        this.limit = limit;
    }
}
