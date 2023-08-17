package cn.felord.payment.wechat.v3.domain.direct.basepay;

import lombok.Data;

/**
 * 单品列表信息
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class GoodsDetail {

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