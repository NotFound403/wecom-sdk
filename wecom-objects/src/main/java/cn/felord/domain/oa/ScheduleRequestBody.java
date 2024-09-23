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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 日程参数
 *
 * @author felord.cn
 * @since 1.0.0
 */
@ToString
@RequiredArgsConstructor
@Getter
public class ScheduleRequestBody {
    /**
     * 日程开始时间
     */
    private final Instant startTime;
    /**
     * 日程结束时间
     */
    private final Instant endTime;
    /**
     * 日程的管理员userid列表，管理员必须在共享成员的列表中。最多指定3人
     */
    private Set<String> admins;
    /**
     * 日程参与者列表。最多支持1000人
     */
    private List<UserId> attendees;
    /**
     * 日程标题。0到128 字符。不填会默认显示为新建事件
     */
    private String summary;
    /**
     * 日程描述
     * 不多于1000个字符
     */
    private String description;
    /**
     * 提醒相关信息
     */
    private Reminders reminders;
    /**
     * 日程所属日历ID。
     * 该日历必须是access_token所对应应用所创建的日历。如果不填，那么插入到access_token所对应应用的默认日历上。
     * 第三方应用必须指定cal_id
     * 不多于64字节
     */
    private String calId;
    /**
     * 日程地址
     * 不多于128个字符
     */
    private String location;
    /**
     * 是否设置为全天日程
     */
    private BoolEnum isWholeDay;

    public ScheduleRequestBody admins(Set<String> admins) {
        this.admins = admins;
        return this;
    }

    public ScheduleRequestBody attendees(List<String> attendees) {
        this.attendees = attendees.stream()
                .map(UserId::new)
                .collect(Collectors.toList());
        return this;
    }

    public ScheduleRequestBody summary(String summary) {
        this.summary = summary;
        return this;
    }

    public ScheduleRequestBody description(String description) {
        this.description = description;
        return this;
    }

    public ScheduleRequestBody reminders(Reminders reminders) {
        this.reminders = reminders;
        return this;
    }

    public ScheduleRequestBody calId(String calId) {
        this.calId = calId;
        return this;
    }

    public ScheduleRequestBody location(String location) {
        this.location = location;
        return this;
    }

    public ScheduleRequestBody isWholeDay(BoolEnum isWholeDay) {
        this.isWholeDay = isWholeDay;
        return this;
    }
}
