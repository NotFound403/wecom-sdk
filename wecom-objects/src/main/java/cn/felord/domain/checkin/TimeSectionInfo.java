/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Duration;

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public class TimeSectionInfo {
    /**
     * 时段id，为班次中某一堆上下班时间组合的id
     */
    private Integer id;
    /**
     * 上班提醒时间。距当天00:00的秒数
     */
    private Duration remindWorkSec;
    /**
     * 下班时间。距当天00:00的秒数
     */
    private Duration offWorkSec;
    /**
     * 上班时间。距当天00:00的秒数
     */
    private Duration workSec;
    /**
     * 下班提醒时间。距当天00:00的秒数
     */
    private Duration remindOffWorkSec;
}