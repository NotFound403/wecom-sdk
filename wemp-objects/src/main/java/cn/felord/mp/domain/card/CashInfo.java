/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.mp.domain.card;

import lombok.Data;

/**
 * 代金券信息
 *
 * @author dax
 * @since 2023 /8/18
 */
@Data
public class CashInfo {
    private final BaseInfo baseInfo;
    /**
     * 代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0
     */
    private final Long least_cost;
    /**
     * 代金券专用，表示减免金额。（单位为分）
     */
    private final Long reduce_cost;
    private AdvancedInfo advancedInfo;
}
