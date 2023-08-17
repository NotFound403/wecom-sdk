package cn.felord.payment.wechat.enumeration;

/**
 * 优惠类型
 *
 * @author felord.cn
 * @since 2023 /8/17 13:53
 */
public enum FundAccountType {

    /**
     * 未结算资金
     */
    UNSETTLED,
    /**
     * 可用余额
     */
    AVAILABLE,
    /**
     * 不可用余额
     */
    UNAVAILABLE,
    /**
     * 运营户
     */
    OPERATION,
    /**
     * 基本账户（含可用余额和不可用余额）
     */
    BASIC
}
