package cn.felord.enumeration;

/**
 * 小程序对外收款-交易状态
 *
 * @author dax
 * @since 2023 /7/6 16:43
 */
public enum MiniPayTradeState {

    /**
     * 支付成功
     */
    SUCCESS,
    /**
     * 转入退款
     */
    REFUND,
    /**
     * 未支付
     */
    NOTPAY,

    /**
     * 已关闭
     */
    CLOSED,
    /**
     * 已撤销（付款码支付）
     */
    REVOKED,
    /**
     * 用户支付中（付款码支付）
     */
    USERPAYING,
    /**
     * 支付失败(其他原因，如银行返回失败)
     */
    PAYERROR,
    /**
     * 已接收，等待扣款
     */
    ACCEPT
}
