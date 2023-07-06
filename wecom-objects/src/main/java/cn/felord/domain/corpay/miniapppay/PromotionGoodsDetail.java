package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * 单品列表信息
 *
 * @author dax
 * @since 2023/7/6 17:05
 */
@Data
public class PromotionGoodsDetail {

    /**
     * 商品编码
     */
    private String goodsId;
    /**
     * 商品数量
     */
    private Long quantity;
    /**
     * 商品单价
     */
    private Long unitPrice;
    /**
     * 商品优惠金额，单位【分】
     */
    private Long discountAmount;
    /**
     * 商品备注
     */
    private String goodsRemark;
}
