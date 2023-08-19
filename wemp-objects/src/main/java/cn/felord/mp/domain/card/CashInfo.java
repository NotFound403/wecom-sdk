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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 代金券信息
 *
 * @author dax
 * @since 2023 /8/18
 */
@ToString
@Getter
public class CashInfo {
    private final BaseInfo baseInfo;
    /**
     * 代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0
     */
    private final Long leastCost;
    /**
     * 代金券专用，表示减免金额。（单位为分）
     */
    private final Long reduceCost;
    private final AdvancedInfo advancedInfo;

    /**
     * Instantiates a new Cash info.
     *
     * @param baseInfo   the base info
     * @param leastCost  the least cost
     * @param reduceCost the reduce cost
     */
    public CashInfo(BaseInfo baseInfo, Long leastCost, Long reduceCost) {
        this(baseInfo, leastCost, reduceCost, null);
    }

    /**
     * Instantiates a new Cash info.
     *
     * @param baseInfo     the base info
     * @param leastCost    the least cost
     * @param reduceCost   the reduce cost
     * @param advancedInfo the advanced info
     */
    @JsonCreator
    public CashInfo(@JsonProperty("base_info") BaseInfo baseInfo, @JsonProperty("least_cost") Long leastCost,
                    @JsonProperty("reduce_cost") Long reduceCost, @JsonProperty("advanced_info") AdvancedInfo advancedInfo) {
        this.baseInfo = baseInfo;
        this.leastCost = leastCost;
        this.reduceCost = reduceCost;
        this.advancedInfo = advancedInfo;
    }
}
