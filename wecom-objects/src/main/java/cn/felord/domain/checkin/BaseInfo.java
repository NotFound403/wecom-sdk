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

import cn.felord.enumeration.CheckinRecordType;
import cn.felord.enumeration.DayDataType;
import lombok.Data;

import java.time.Instant;

@Data
public class BaseInfo {
    /**
     * 日报日期
     */
    private Instant date;
    /**
     * 日报类型：0-工作日日报；1-休息日日报
     */
    private DayDataType dayType;
    /**
     * 打卡人员姓名
     */
    private String name;
    /**
     * 打卡人员别名
     */
    private String nameEx;
    /**
     * 打卡人员所在部门，会显示所有所在部门
     */
    private String departsName;
    /**
     * 打卡人员所属规则信息
     */
    private RuleInfo ruleInfo;
    /**
     * 打卡人员账号，即userid
     */
    private String acctid;
    /**
     * 记录类型：1-固定上下班；2-外出（此报表中不会出现外出打卡数据）；3-按班次上下班；4-自由签到；5-加班；7-无规则
     */
    private CheckinRecordType recordType;
}
