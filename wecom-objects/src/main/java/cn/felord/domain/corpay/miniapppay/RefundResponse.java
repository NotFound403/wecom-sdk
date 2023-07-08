package cn.felord.domain.corpay.miniapppay;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/7/7 8:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundResponse extends WeComResponse {
    private String outRefundNo;
    private RefundAmount amount;
    private RefundPromotionDetail promotionDetail;
}
