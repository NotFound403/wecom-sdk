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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CondSource;
import lombok.Data;

import java.time.LocalDate;

/**
 * 卡券概况数据
 * <p>
 * 查询时间区间需小于等于62天。只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class CardBizRequest {
    private final LocalDate beginDate;
    private final LocalDate endDate;
    private final CondSource condSource;
}
