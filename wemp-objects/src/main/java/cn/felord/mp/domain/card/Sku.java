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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Sku.
 *
 * @author dax
 * @since 2024/8/18 11:15
 */
@ToString
@Getter
public class Sku {
    private final Long quantity;
    private final Long totalQuantity;


    /**
     * Instantiates a new Sku.
     *
     * @param quantity the quantity
     */
    public Sku(@JsonProperty("quantity") Long quantity) {
        this(quantity, null);
    }

    /**
     * Instantiates a new Sku.
     *
     * @param quantity      the quantity
     * @param totalQuantity the total quantity
     */
    @JsonCreator
    Sku(@JsonProperty("quantity") Long quantity, @JsonProperty("total_quantity") Long totalQuantity) {
        this.quantity = quantity;
        this.totalQuantity = totalQuantity;
    }
}
