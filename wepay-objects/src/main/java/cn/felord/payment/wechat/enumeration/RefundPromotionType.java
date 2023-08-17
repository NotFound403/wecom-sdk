package cn.felord.payment.wechat.enumeration;

/**
 * 优惠范围
 *
 * @author felord.cn
 * @since 2023/8/17 13:53
 */
public enum RefundPromotionType {

    /**
     * 代金券，需要走结算资金的充值型代金券
     */
    COUPON,
    /**
     * 优惠券，不走结算资金的免充值型优惠券
     */
    DISCOUNT
}
