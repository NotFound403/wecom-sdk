package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class OrderAmount {

    /**
     * 订单总金额，单位为分。
     */
    private Integer total;
    /**
     * 用户支付金额，单位为分。
     */
    private Integer payerTotal;
    /**
     * CNY：人民币，境内商户号仅支持人民币。
     */
    private String currency;
    /**
     * 用户支付币种
     */
    private String payerCurrency;
}