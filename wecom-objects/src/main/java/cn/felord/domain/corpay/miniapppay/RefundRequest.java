package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class RefundRequest {
    private final String mchid;
    private final String appid;
    private final String outTradeNo;
    private final String outRefundNo;
    private final RefundAmount amount;
    private String reason;
    private String fundsAccount;
}