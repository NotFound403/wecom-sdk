package cn.felord.enumeration;

/**
 * @author dax
 * @since 2023/6/26 15:01
 */
public enum RedPackStatus {
    /**
     * 发放
     */
    SENDING,
    /**
     * 已发放待领取
     */
    SENT,
    /**
     * 发放失败
     */
    FAILED,
    /**
     * 已领取
     */
    RECEIVED,
    /**
     * 退款中
     */
    RFUND_ING,
    /**
     * 已退款
     */
    REFUND
}
