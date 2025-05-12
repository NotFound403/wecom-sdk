/*
 * Copyright (c) 2025. felord.cn
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

package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormForkFinishType;
import cn.felord.enumeration.FormRepeatType;
import cn.felord.enumeration.FormWeekFlag;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/13 17:17
 */
@Data
public class TimedRepeatInfo {
    /**
     * 是否开启定时重复
     */
    private Boolean enable;
    /**
     * 提醒时间，为第一次提醒的时间戳。重复提醒的时间根据timed_repeat_info的相关字段计算。
     * 如remind_time设置为当天10:00的时间戳，同时repeated_type设置了每天重复，那么每天的10:00都会触发提醒。
     */
    private Instant remindTime;
    /**
     * 重复类型。0：每周；1：每天；2：每月
     */
    private FormRepeatType repeatType;
    /**
     * 自动跳过节假日，只能repeat_type = 1 时填写。
     */
    private Boolean skipHoliday;
    /**
     * 每周几重复，按bit组合，只能repeat_type = 0 时填写。
     * bit 0: 周一； bit 1: 周二；bit 2: 周三；bit 3: 周四； bit 4: 周五；bit 5: 周六 bit 6: 周日。如1表示周一，2表示周二，4表示周三，96表示周六和周日
     */
    private FormWeekFlag weekFlag;
    /**
     * 每月的第几天（1 - 31），只能repeat_type = 2时填写
     */
    private Integer dayOfMonth;
    /**
     * 是否允许补填
     */
    private FormForkFinishType forkFinishType;
}
