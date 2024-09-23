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

package cn.felord.domain.approval;

import cn.felord.enumeration.SliceState;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

/**
 * The type Slice info.
 *
 * @author dax
 * @since 2023 /12/19
 */
@Getter
public class SliceInfo {
    private final Duration duration;
    private final SliceState state;
    private final List<DayItem> dayItems;

    /**
     * Instantiates a new Slice info.
     *
     * @param duration the duration
     * @param state    the state
     * @param dayItems the day items
     */
    @JsonCreator
    SliceInfo(@JsonProperty("duration") Duration duration,
              @JsonProperty("state") SliceState state,
              @JsonProperty("day_items") List<DayItem> dayItems) {
        this.duration = duration;
        this.state = state;
        this.dayItems = dayItems;
    }

    /**
     * Instantiates a new Slice info.
     *
     * @param dayItems the day items
     */
    public SliceInfo(List<DayItem> dayItems) {
        this(null, null, dayItems);
    }
}
