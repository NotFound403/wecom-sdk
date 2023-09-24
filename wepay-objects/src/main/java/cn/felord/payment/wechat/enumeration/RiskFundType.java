package cn.felord.payment.wechat.enumeration;

/**
 * 风险金类型
 *
 * @author dax
 * @since 2023/8/22
 */
public enum RiskFundType {
    /**
     * 押金
     */
    DEPOSIT,
    /**
     * 预付款
     */
    ADVANCE,
    /**
     * 保证金
     */
    CASH_DEPOSIT,
    /**
     * 预估订单费用
     * <p>
     * 【先享模式】（评估不通过不可使用服务）
     */
    ESTIMATE_ORDER_COST
}
