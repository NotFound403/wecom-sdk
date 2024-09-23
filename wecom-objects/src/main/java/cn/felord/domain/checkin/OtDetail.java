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

@Data
public class OtDetail {
    /**
     * 允许工作日加班-加班开始时间：下班后xx秒开始计算加班，距离最晚下班时间的秒数，例如，1800（30分钟 乘以 60秒），默认值30分钟
     */
    private Integer otWorkingdayTimeStart;
    /**
     * 允许工作日加班-最短加班时长：不足xx秒视为未加班，单位秒，默认值30分钟
     */
    private Integer otWorkingdayTimeMin;
    /**
     * 允许工作日加班-最长加班时长：超过则视为加班xx秒，单位秒，默认值240分钟
     */
    private Integer otWorkingdayTimeMax;
    /**
     * 允许非工作日加班-最短加班时长：不足xx秒视为未加班，单位秒，默认值30分钟
     */
    private Integer otNonworkingdayTimeMin;
    /**
     * 允许非工作日加班-最长加班时长：超过则视为加班xx秒 单位秒，默认值240分钟
     */
    private Integer otNonworkingdayTimeMax;
    /**
     * 非工作日加班，跨天时间，距离当天00:00的秒数
     */
    private Integer otNonworkingdaySpandayTime;

    //todo
}
