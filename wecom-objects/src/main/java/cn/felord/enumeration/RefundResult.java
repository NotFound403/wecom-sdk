package cn.felord.enumeration;

/**
 * @author dax
 * @since 2023/7/7 8:54
 */
public enum RefundResult {
    /**
     * 退款成功
     */
    SUCCESS,
    /**
     * 退款关闭
     */
    CLOSE,
    /**
     * 退款处理中
     */
    PROCESSING,
    /**
     * 退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败
     */
    ABNORMAL
}
