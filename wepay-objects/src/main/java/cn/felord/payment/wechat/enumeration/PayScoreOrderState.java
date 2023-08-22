package cn.felord.payment.wechat.enumeration;

/**
 * 服务订单状态
 *
 * @author dax
 * @since 2023 /8/22
 */
public enum PayScoreOrderState {
    /**
     * 商户已创建服务订单
     */
    CREATED,
    /**
     * 服务订单进行中
     */
    DOING,

    /**
     * 服务订单完成
     */
    DONE,
    /**
     * 商户取消服务订单
     */
    REVOKED,
    /**
     * 服务订单已失效
     */
    EXPIRED

}
