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

package cn.felord.payment.wechat.v3.domain.direct.basepay;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * 退款订单的商品信息
 *
 * @author felord.cn
 * @since 1.0.6.RELEASE
 */
@Getter
public class RefundGoodsDetail {
    /**
     * 商户侧商品编码
     */
    private final String merchantGoodsId;
    /**
     * 微信侧商品编码
     */
    private String wechatpayGoodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品单价金额，单位为分。
     */
    private final Long unitPrice;
    /**
     * 商品退款金额，单位为分。
     */
    private final Long refundAmount;
    /**
     * 单品的退款数量。
     */
    private final Integer refundQuantity;

    /**
     * Instantiates a new Refund goods detail.
     *
     * @param merchantGoodsId the merchant goods id
     * @param unitPrice       the unit price
     * @param refundAmount    the refund amount
     * @param refundQuantity  the refund quantity
     */
    public RefundGoodsDetail(String merchantGoodsId, long unitPrice, long refundAmount, int refundQuantity) {
        this.merchantGoodsId = merchantGoodsId;
        this.unitPrice = unitPrice;
        this.refundAmount = refundAmount;
        this.refundQuantity = refundQuantity;
    }

    /**
     * Instantiates a new Refund goods detail.
     *
     * @param merchantGoodsId  the merchant goods id
     * @param wechatpayGoodsId the wechatpay goods id
     * @param goodsName        the goods name
     * @param unitPrice        the unit price
     * @param refundAmount     the refund amount
     * @param refundQuantity   the refund quantity
     */
    @JsonCreator
    RefundGoodsDetail(@JsonProperty("merchant_goods_id") String merchantGoodsId,
                      @JsonProperty("wechatpay_goods_id") String wechatpayGoodsId,
                      @JsonProperty("goods_name") String goodsName,
                      @JsonProperty("unit_price") Long unitPrice,
                      @JsonProperty("refund_amount") Long refundAmount,
                      @JsonProperty("refund_quantity") Integer refundQuantity) {
        this.merchantGoodsId = merchantGoodsId;
        this.wechatpayGoodsId = wechatpayGoodsId;
        this.goodsName = goodsName;
        this.unitPrice = unitPrice;
        this.refundAmount = refundAmount;
        this.refundQuantity = refundQuantity;
    }

    /**
     * Wechatpay goods id refund goods detail.
     *
     * @param wechatpayGoodsId the wechatpay goods id
     * @return the refund goods detail
     */
    public RefundGoodsDetail wechatpayGoodsId(String wechatpayGoodsId) {
        this.wechatpayGoodsId = wechatpayGoodsId;
        return this;
    }

    /**
     * Goods name refund goods detail.
     *
     * @param goodsName the goods name
     * @return the refund goods detail
     */
    public RefundGoodsDetail goodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }
}
