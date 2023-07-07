package cn.felord.domain.corpay.miniapppay;

import cn.felord.enumeration.CashType;
import cn.felord.enumeration.PromotionScope;
import lombok.Data;

/**
 * @author dax
 * @since 2023/7/7 8:35
 */
@Data
public class RefundPromotionDetail {
    private String promotionId;
    private PromotionScope scope;
    private CashType type;
    private Integer amount;
    private Integer refundAmount;
}
