package cn.felord.enumeration;

/**
 * 小程序对外收款-交易类型
 *
 * @author dax
 * @since 2023/7/6 16:37
 */
public enum MiniPayTradeType {

    /**
     * 公众号支付
     */
    JSAPI,
    /**
     * 扫码支付
     */
    NATIVE,
    /**
     * APP支付
     */
    APP,
    /**
     * 付款码支付
     */
    MICROPAY,
    /**
     * H5支付
     */
    MWEB,
    /**
     * 刷脸支付
     */
    FACEPAY
}
