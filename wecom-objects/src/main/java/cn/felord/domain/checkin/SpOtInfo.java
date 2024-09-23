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

import cn.felord.enumeration.SpOtStatus;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public class SpOtInfo {
    /**
     * 状态：0-无加班；1-正常；2-缺时长
     */
    private SpOtStatus otStatus;
    /**
     * 加班时长
     */
    private Duration otDuration;
    /**
     * ot_status为2下，加班不足的时长
     */
    private List<Duration> exceptionDuration;
    /**
     * 工作日加班记为调休，单位秒
     */
    private Duration workdayOverAsVacation;
    /**
     * 工作日加班记为加班费，单位秒
     */
    private Duration workdayOverAsMoney;
    /**
     * 休息日加班记为调休，单位秒
     */
    private Duration restdayOverAsVacation;
    /**
     * 休息日加班记为加班费，单位秒
     */
    private Duration restdayOverAsMoney;
    /**
     * 节假日加班记为调休，单位秒
     */
    private Duration holidayOverAsVacation;
    /**
     * 节假日加班记为加班费，单位秒
     */
    private Duration holidayOverAsMoney;

}
