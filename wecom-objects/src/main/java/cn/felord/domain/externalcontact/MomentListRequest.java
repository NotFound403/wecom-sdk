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

import cn.felord.enumeration.ListFilterType;
import lombok.Getter;

import java.time.Instant;

/**
 * The type Moment list request.
 *
 * @author dax
 * @since 2021 /10/19 19:43
 */
@Getter
public class MomentListRequest {
    private final Instant startTime;
    private final Instant endTime;
    private String creator;
    private String cursor;
    private ListFilterType filterType;
    private Integer limit;

    /**
     * Instantiates a new Moment list request.
     *
     * @param startTime the start time
     * @param endTime   the end time
     */
    public MomentListRequest(Instant startTime, Instant endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Creator moment list request.
     *
     * @param creator the creator
     * @return the moment list request
     */
    public MomentListRequest creator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * Cursor moment list request.
     *
     * @param cursor the cursor
     * @return the moment list request
     */
    public MomentListRequest cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Filter type moment list request.
     *
     * @param filterType the filter type
     * @return the moment list request
     */
    public MomentListRequest filterType(ListFilterType filterType) {
        this.filterType = filterType;
        return this;
    }

    /**
     * Limit moment list request.
     *
     * @param limit the limit
     * @return the moment list request
     */
    public MomentListRequest limit(int limit) {
        this.limit = limit;
        return this;
    }
}
