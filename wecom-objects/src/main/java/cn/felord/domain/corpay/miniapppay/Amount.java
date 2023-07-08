package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class Amount {
    private final Integer total;
    private final String currency;


    /**
     * Instantiates a new Amount.
     *
     * @param total    the total
     * @param currency the currency
     */
    public Amount(int total, String currency) {
        this.total = total;
        this.currency = currency;
    }


    /**
     * RMB 专用
     *
     * @param total the total
     * @return the amount
     */
    public static Amount rmb(int total) {
        return new Amount(total, "CNY");
    }
}