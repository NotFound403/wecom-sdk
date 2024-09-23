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
import cn.felord.enumeration.DayOfMonth;
import cn.felord.enumeration.RemindBeforeEventSecs;
import cn.felord.enumeration.RemindTimeDiff;
import cn.felord.enumeration.RepeatType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 提醒相关信息
 *
 * @author felord.cn
 * @since 1.0.0
 */
@ToString
@Getter
public class Reminders {
    /**
     * 是否需要提醒
     */
    private BoolEnum isRemind;
    /**
     * 是否重复日程
     */
    private BoolEnum isRepeat;
    /**
     * 日程开始（start_time）前多少秒提醒，当is_remind为1时有效。
     */
    private RemindBeforeEventSecs remindBeforeEventSecs;
    /**
     * 提醒时间与日程开始时间（start_time）的差值，当is_remind为1时有效，可以指定多个提醒时间
     */
    private List<RemindTimeDiff> remindTimeDiffs;
    /**
     * 重复类型，当is_repeat为1时有效。
     */
    private RepeatType repeatType;
    /**
     * 重复结束时刻，Unix时间戳，当is_repeat为1时有效。不填或填0表示一直重复
     */
    private Instant repeatUntil;
    /**
     * 是否自定义重复。0-否；1-是。当is_repeat为1时有效。
     */
    private BoolEnum isCustomRepeat;
    /**
     * 重复间隔。
     * 仅当指定为自定义重复时有效，
     * 该字段随repeat_type不同而含义不同，
     * 例如：
     * <p>
     * repeat_interval指定为3，repeat_type指定为每周重复，那么每3周重复一次；
     * repeat_interval指定为3，repeat_type指定为每月重复，那么每3个月重复一次
     */
    private Integer repeatInterval;
    /**
     * 每月哪几天重复，
     * 仅当指定为自定义重复且重复类型为每月时有效，取值范围：1到31，分别表示1到31号
     */
    private List<DayOfMonth> repeatDayOfMonth;
    /**
     * 每周周几重复
     * 仅当指定为自定义重复且重复类型为每周时有效
     * 取值范围：1到7，分别表示周一至周日
     */
    private List<Integer> repeatDayOfWeek;
    /**
     * 时区。UTC偏移量表示(即偏离零时区的小时数)，东区为正数，西区为负数。
     */
    private Integer timezone;

    /**
     * Instantiates a new Reminders.
     */
    public Reminders() {
    }

    /**
     * Instantiates a new Reminders.
     *
     * @param isRemind              the is remind
     * @param isRepeat              the is repeat
     * @param remindBeforeEventSecs the remind before event secs
     * @param remindTimeDiffs       the remind time diffs
     * @param repeatType            the repeat type
     * @param repeatUntil           the repeat until
     * @param isCustomRepeat        the is custom repeat
     * @param repeatInterval        the repeat interval
     * @param repeatDayOfMonth      the repeat day of month
     * @param repeatDayOfWeek       the repeat day of week
     * @param timezone              the timezone
     */
    @JsonCreator
    Reminders(@JsonProperty("is_remind") BoolEnum isRemind,
              @JsonProperty("is_repeat") BoolEnum isRepeat,
              @JsonProperty("remind_before_event_secs") RemindBeforeEventSecs remindBeforeEventSecs,
              @JsonProperty("remind_time_diffs") List<RemindTimeDiff> remindTimeDiffs,
              @JsonProperty("repeat_type") RepeatType repeatType,
              @JsonProperty("repeat_until") Instant repeatUntil,
              @JsonProperty("is_custom_repeat") BoolEnum isCustomRepeat,
              @JsonProperty("repeat_interval") Integer repeatInterval,
              @JsonProperty("repeat_day_of_month") List<DayOfMonth> repeatDayOfMonth,
              @JsonProperty("repeat_day_of_week") List<Integer> repeatDayOfWeek,
              @JsonProperty("timezone") Integer timezone) {
        this.isRemind = isRemind;
        this.isRepeat = isRepeat;
        this.remindBeforeEventSecs = remindBeforeEventSecs;
        this.remindTimeDiffs = remindTimeDiffs;
        this.repeatType = repeatType;
        this.repeatUntil = repeatUntil;
        this.isCustomRepeat = isCustomRepeat;
        this.repeatInterval = repeatInterval;
        this.repeatDayOfMonth = repeatDayOfMonth;
        this.repeatDayOfWeek = repeatDayOfWeek;
        this.timezone = timezone;
    }

    /**
     * 开启提醒
     *
     * @return the reminders
     */
    public Reminders remind() {
        this.isRemind = BoolEnum.TRUE;
        return this;
    }

    /**
     * 开启多个时间点前提醒
     *
     * @param remindTimeDiffs the remind time diffs
     * @return the reminders
     */
    public Reminders remind(List<RemindTimeDiff> remindTimeDiffs) {
        this.isRemind = BoolEnum.TRUE;
        this.remindTimeDiffs = remindTimeDiffs;
        return this;
    }

    /**
     * 开启N秒前提醒
     *
     * @param remindBeforeEventSecs the remind before event secs
     * @return the reminders
     */
    public Reminders remind(RemindBeforeEventSecs remindBeforeEventSecs) {
        this.isRemind = BoolEnum.TRUE;
        this.remindBeforeEventSecs = remindBeforeEventSecs;
        return this;
    }

    /**
     * 开启重复提醒
     *
     * @return the reminders
     */
    public Reminders repeat() {
        this.isRepeat = BoolEnum.TRUE;
        return this;
    }

    /**
     * 开启按类型重复
     *
     * @param repeatType the repeat type
     * @return the reminders
     */
    public Reminders repeat(RepeatType repeatType) {
        this.isRepeat = BoolEnum.TRUE;
        this.repeatType = repeatType;
        return this;
    }

    /**
     * 开启按类型重复，并定义结束时刻
     *
     * @param repeatType  the repeat type
     * @param repeatUntil the repeat until
     * @return the reminders
     */
    public Reminders repeat(RepeatType repeatType, Instant repeatUntil) {
        this.isRepeat = BoolEnum.TRUE;
        this.repeatType = repeatType;
        this.repeatUntil = repeatUntil;
        return this;
    }

    /**
     * 开启按类型自定义重复，并定义重复间隔
     *
     * @param repeatType     the repeat type
     * @param repeatInterval the repeat interval
     * @return the reminders
     */
    public Reminders repeat(RepeatType repeatType, int repeatInterval) {
        this.isRepeat = BoolEnum.TRUE;
        this.isCustomRepeat = BoolEnum.TRUE;
        this.repeatType = repeatType;
        this.repeatInterval = repeatInterval;
        return this;
    }

    /**
     * 自定义重复，每周周几重复
     *
     * @param dayOfWeek the day of week
     * @return the reminders
     */
    public Reminders repeat(List<DayOfWeek> dayOfWeek) {
        this.isRepeat = BoolEnum.TRUE;
        this.isCustomRepeat = BoolEnum.TRUE;
        this.repeatType = RepeatType.EACH_WEEK;
        this.repeatDayOfWeek = dayOfWeek.stream()
                .map(DayOfWeek::getValue)
                .collect(Collectors.toList());
        return this;
    }

    /**
     * 自定义重复，每月几号重复
     *
     * @param dayOfMonth the day of month
     * @return the reminders
     */
    public Reminders repeat(ArrayList<DayOfMonth> dayOfMonth) {
        this.isRepeat = BoolEnum.TRUE;
        this.isCustomRepeat = BoolEnum.TRUE;
        this.repeatType = RepeatType.EACH_MONTH;
        this.repeatDayOfMonth = dayOfMonth;
        return this;
    }

    /**
     * 设置时区
     *
     * @param timezone the timezone
     * @return the reminders
     */
    public Reminders timezone(int timezone) {
        this.timezone = timezone;
        return this;
    }

}
