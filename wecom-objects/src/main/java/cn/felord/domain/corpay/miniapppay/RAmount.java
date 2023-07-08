package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class RAmount {
    private Integer payerRefund;
    private Integer discountRefund;
    private String currency;
    private Integer refund;
}