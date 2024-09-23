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

import java.time.Instant;

@Data
public class OtInfoV2 {
    /**
     * 工作日加班配置
     */
    private Workdayconf workdayconf;
    /**
     * 休息日加班配置
     */
    private Restdayconf restdayconf;
    /**
     * 节假日加班配置
     */
    private Holidayconf holidayconf;
    /**
     * 更新时间
     */
    private Instant updatetime;
}
