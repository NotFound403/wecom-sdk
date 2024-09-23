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

package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Duration;

@Data
public class CheckinTime {
    /**
     * ID
     */
    private Integer timeId;
    /**
     * 上班时间，表示为距离当天0点的秒数
     */
    private Duration workSec;
    /**
     * 下班时间，表示为距离当天0点的秒数。
     */
    private Duration offWorkSec;
    /**
     * 当前距离上班时间，表示为距离当天0点的秒数。
     */
    private Duration latestWorkSec;
    /**
     * 当前距离下班时间，表示为距离当天0点的秒数。
     */
    private Duration latestOffWorkSec;
    /**
     * 最早上班时间，表示为距离当天0点的秒数。
     */
    private Duration earliestWorkSec;
    /**
     * 最早下班时间，表示为距离当天0点的秒数。
     */
    private Duration earliestOffWorkSec;
    /**
     * 上班提醒时间，表示为距离当天0点的秒数。
     */
    private Duration remindWorkSec;
    /**
     * 下班提醒时间，表示为距离当天0点的秒数。
     */
    private Duration remindOffWorkSec;
    /**
     * 允许午休
     */
    private Boolean allowRest;
    /**
     * 午休开始时间，表示为距离当天0点的秒数。
     */
    private Duration restBeginTime;
    /**
     * 午休结束时间，表示为距离当天0点的秒数。
     */
    private Duration restEndTime;
    /**
     * 不需要检查上班
     */
    private Boolean noNeedCheckon;
    /**
     * 不需要检查下班
     */
    private Boolean noNeedCheckoff;
}
