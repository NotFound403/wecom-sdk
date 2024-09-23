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

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * The type Calendar update request.
 *
 * @author felord
 * @since 2021 /11/22 11:37
 */
@Getter
public class CalendarUpdateRequest {
    private final BoolEnum skipPublicRange;
    private final CalendarUpdateBody calendar;

    /**
     * Instantiates a new Calendar update request.
     *
     * @param calendar the calendar
     */
    public CalendarUpdateRequest(CalendarUpdateBody calendar) {
        this(BoolEnum.FALSE, calendar);
    }

    /**
     * Instantiates a new Calendar update request.
     *
     * @param skipPublicRange the skip public range
     * @param calendar        the calendar
     */
    public CalendarUpdateRequest(BoolEnum skipPublicRange, CalendarUpdateBody calendar) {
        this.skipPublicRange = skipPublicRange;
        this.calendar = calendar;
    }
}
