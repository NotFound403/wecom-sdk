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

import cn.felord.domain.common.UserId;
import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Set;

/**
 * @author felord
 * @since 2021/11/21 15:46
 */
@Data
public class ScheduleUpdateBody {
    private final String scheduleId;
    private final Instant startTime;
    private final Instant endTime;
    private Set<String> admins;
    private List<UserId> attendees;
    private String summary;
    private String description;
    private Reminders reminders;
    private String calId;
    private String location;
    private BoolEnum isAllday;
}
