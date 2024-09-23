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
 * 加班信息
 */
@Data
public class OtInfo {
    /**
     * 是否允许非工作日加班
     */
    private Boolean allowOtNonworkingday;
    /**
     * 加班申请信息
     */
    private Otapplyinfo otapplyinfo;
    /**
     * 是否允许工作日加班
     */
    private Boolean allowOtWorkingday;
    /**
     * 加班类型
     */
    private Integer type;
    /**
     * 加班信息
     */
    private OtDetail otcheckinfo;
    /**
     * 加班更新时间
     */
    private Integer uptime;
}
