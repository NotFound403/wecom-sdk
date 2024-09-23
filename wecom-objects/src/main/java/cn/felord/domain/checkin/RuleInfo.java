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

import java.util.List;

@Data
public class RuleInfo {
    /**
     * 所属规则的id
     */
    private Integer groupid;
    /**
     * 打卡规则名
     */
    private String groupname;
    /**
     * （日报）当日所属班次id，仅按班次上下班才有值，显示在打卡日报-班次列
     */
    private Integer scheduleid;
    /**
     * （日报）当日所属班次名称，仅按班次上下班才有值，显示在打卡日报-班次列
     */
    private String schedulename;
    /**
     * （日报）当日打卡时间，仅固定上下班规则有值，显示在打卡日报-班次列
     */
    private List<CheckinDayTime> checkintime;
}
