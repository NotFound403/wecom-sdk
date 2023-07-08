package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class RefundAmount {
    private final Integer total;
    private final String currency;
    private final Integer refund;


    /**
     * Instantiates a new Refund amount.
     *
     * @param total    the total
     * @param currency the currency
     * @param refund   the refund
     */
    public RefundAmount(int total, String currency, int refund) {
        this.total = total;
        this.currency = currency;
        this.refund = refund;
    }


    /**
     * Rmb refund amount.
     *
     * @param total  the total
     * @param refund the refund
     * @return the refund amount
     */
    public static RefundAmount rmb(int total, int refund) {
        return new RefundAmount(total, "CNY", refund);
    }
}