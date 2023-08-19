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
 * 折扣券信息
 *
 * @author dax
 * @since 2023 /8/18
 */
@ToString
@Getter
public class DiscountInfo {
    private final BaseInfo baseInfo;
    /**
     * 折扣，该会员卡享受的折扣优惠, (100-x)%
     */
    private final Integer discount;
    private final AdvancedInfo advancedInfo;

    /**
     * Instantiates a new Discount info.
     *
     * @param baseInfo the base info
     * @param discount the discount
     */
    public DiscountInfo(BaseInfo baseInfo, Integer discount) {
        this(baseInfo, discount, null);
    }

    /**
     * Instantiates a new Discount info.
     *
     * @param baseInfo     the base info
     * @param discount     the discount
     * @param advancedInfo the advanced info
     */
    @JsonCreator
    public DiscountInfo(@JsonProperty("base_info") BaseInfo baseInfo,
                        @JsonProperty("discount") Integer discount,
                        @JsonProperty("advanced_info") AdvancedInfo advancedInfo) {
        this.baseInfo = baseInfo;
        this.discount = discount;
        this.advancedInfo = advancedInfo;
    }
}
