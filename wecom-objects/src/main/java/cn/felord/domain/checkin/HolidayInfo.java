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

/**
 * The type Holiday info.
 */
@Data
public class HolidayInfo {
    /**
     * 假勤申请id，即当日关联的假勤审批单id
     */
    private String spNumber;
    /**
     * 假勤信息摘要-标题信息，目前只有中文一种
     */
    private SpTitle spTitle;
    /**
     * 假勤信息摘要-描述信息，目前只有中文一种
     */
    private SpDescription spDescription;
}
