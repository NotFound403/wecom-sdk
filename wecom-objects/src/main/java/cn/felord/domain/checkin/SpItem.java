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

import cn.felord.enumeration.CheckinSpTimeType;
import cn.felord.enumeration.CheckinSpType;
import lombok.Data;

import java.time.Duration;

/**
 * 假勤统计信息
 */
@Data
public class SpItem {
    /**
     * 当日假勤时长秒数
     */
    private Duration duration;
    /**
     * 时长单位：0-按天 1-按小时
     */
    private CheckinSpTimeType timeType;
    /**
     * 当日假勤次数
     */
    private Integer count;
    /**
     * 统计项名称
     */
    private String name;
    /**
     * 具体请假类型，当type为1请假时，具体的请假类型id，可通过审批相关接口获取假期详情
     */
    private Integer vacationId;
    /**
     * 类型：1-请假；2-补卡；3-出差；4-外出；100-外勤
     */
    private CheckinSpType type;
}
