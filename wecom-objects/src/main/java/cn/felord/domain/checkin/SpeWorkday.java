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
import java.util.List;

/**
 * @author dax
 * @since 2023/9/25
 */
@Data
public class SpeWorkday {
    /**
     * 特殊日期-必须打卡日期时间戳
     */
    private Instant timestamp;
    /**
     * 特殊日期备注
     */
    private String notes;
    /**
     * 特殊日期-必须打卡日期-上下班打卡时间
     */
    private List<CheckinTime> checkintime;
}
