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

package cn.felord.domain.corpay.miniapppay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@ToString
@Getter
public class GoodsDetailItem {
    private final String merchantGoodsId;
    private final Integer quantity;
    private final Long unitPrice;
    private final String goodsName;
    private final String wechatpayGoodsId;

    /**
     * Instantiates a new Goods detail item.
     *
     * @param merchantGoodsId the merchant goods id
     * @param quantity        the quantity
     * @param unitPrice       the unit price
     */
    public GoodsDetailItem(String merchantGoodsId, int quantity, long unitPrice) {
        this(merchantGoodsId, quantity, unitPrice, null);
    }

    /**
     * Instantiates a new Goods detail item.
     *
     * @param merchantGoodsId the merchant goods id
     * @param quantity        the quantity
     * @param unitPrice       the unit price
     * @param goodsName       the goods name
     */
    public GoodsDetailItem(String merchantGoodsId, int quantity, long unitPrice, String goodsName) {
        this(merchantGoodsId, quantity, unitPrice, goodsName, null);
    }

    /**
     * Instantiates a new Goods detail item.
     *
     * @param merchantGoodsId  the merchant goods id
     * @param quantity         the quantity
     * @param unitPrice        the unit price
     * @param goodsName        the goods name
     * @param wechatpayGoodsId the wechatpay goods id
     */
    @JsonCreator
    public GoodsDetailItem(@JsonProperty("merchant_goods_id") String merchantGoodsId,
                           @JsonProperty("quantity") int quantity,
                           @JsonProperty("unit_price") long unitPrice,
                           @JsonProperty("goods_name") String goodsName,
                           @JsonProperty("wechatpay_goods_id") String wechatpayGoodsId) {
        this.merchantGoodsId = merchantGoodsId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.goodsName = goodsName;
        this.wechatpayGoodsId = wechatpayGoodsId;
    }
}
