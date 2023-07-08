package cn.felord.domain.corpay.miniapppay;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.RefundChannel;
import cn.felord.enumeration.RefundResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

/**
 * 退款记录
 * <p>
 * 返回UTC时间需要自行转换为东八区
 *
 * @author dax
 * @since 2023 /7/6 16:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundDetailResponse extends WeComResponse {
    private String refundId;
    private String outRefundNo;
    private String transactionId;
    private String outTradeNo;
    private RefundChannel channel;
    private String userReceivedAccount;
    private OffsetDateTime successTime;
    private OffsetDateTime createTime;
    private RefundResult status;
    private RAmount amount;
    private RefundPromotionDetail promotionDetail;
}