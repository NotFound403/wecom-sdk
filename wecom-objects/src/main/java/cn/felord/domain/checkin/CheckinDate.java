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

import cn.felord.enumeration.WeekDay;
import lombok.Data;

import java.util.List;

@Data
public class CheckinDate {
    /**
     * 工作日。
     */
    private List<WeekDay> workdays;
    /**
     * 工作日上下班打卡时间信息
     */
    private List<CheckinTime> checkintime;
    /**
     * 下班不需要打卡，true为下班不需要打卡，false为下班需要打卡
     */
    private Boolean noneedOffwork;
    /**
     * 允许迟到时间，单位ms
     */
    private Integer flexOnDutyTime;
    /**
     * 允许早退时间，单位ms
     */
    private Integer flexOffDutyTime;
    /**
     * 允许早到
     */
    private Integer maxAllowArriveEarly;
    /**
     * 限制提前时间（毫秒）
     */
    private Integer limitAheadtime;
    /**
     * 迟到规则
     */
    private LateRule lateRule;
    /**
     * 允许晚到
     */
    private Integer maxAllowArriveLate;
    /**
     * 弹性
     */
    private Boolean allowFlex;
}
