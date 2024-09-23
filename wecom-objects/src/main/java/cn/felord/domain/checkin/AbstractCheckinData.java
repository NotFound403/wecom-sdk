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

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public abstract class AbstractCheckinData {
    /**
     * 基础信息
     */
    private BaseInfo baseInfo;
    /**
     * 校准状态信息
     */
    private List<ExceptionInfo> exceptionInfos;
    /**
     * 假勤统计信息
     */
    private List<SpItem> spItems;
    /**
     * 加班信息
     */
    private SpOtInfo otInfo;
}
