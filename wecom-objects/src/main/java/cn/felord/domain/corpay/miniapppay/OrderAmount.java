package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class OrderAmount {
    private Integer total;
    private Integer payerTotal;
    private String currency;
    private String payerCurrency;
}