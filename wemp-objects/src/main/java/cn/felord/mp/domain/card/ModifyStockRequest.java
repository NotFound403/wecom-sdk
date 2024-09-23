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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 修改库存接口
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ModifyStockRequest {
    private final String cardId;
    private final Integer increaseStockValue;
    private final Integer reduceStockValue;

    /**
     * 增加库存
     *
     * @param cardId             the card id
     * @param increaseStockValue the increase stock value
     * @return the modify stock request
     */
    public static ModifyStockRequest increaseStock(String cardId, int increaseStockValue) {
        return new ModifyStockRequest(cardId, increaseStockValue, null);
    }

    /**
     * 减少库存
     *
     * @param cardId           the card id
     * @param reduceStockValue the reduce stock value
     * @return the modify stock request
     */
    public static ModifyStockRequest reduceStock(String cardId, int reduceStockValue) {
        return new ModifyStockRequest(cardId, null, reduceStockValue);
    }
}
