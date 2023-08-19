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

import cn.felord.mp.enumeration.CardType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 折扣券
 *
 * @author dax
 * @since 2023 /8/18
 */
@ToString
@Getter
public class DiscountCard extends AbstractCard {
    private final DiscountInfo discount;

    /**
     * Instantiates a new Discount card.
     *
     * @param discount the discount
     */
    @JsonCreator
    public DiscountCard(@JsonProperty("discount") DiscountInfo discount) {
        super(CardType.DISCOUNT);
        this.discount = discount;
    }
}
