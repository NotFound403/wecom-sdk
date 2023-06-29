
package cn.felord.domain.corpay.external;

import cn.felord.enumeration.RefundStatus;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/29 16:20
 */
@Data
public class RefundInfo {

    private String outRefundNo;
    private String refundComment;
    private Long refundFee;
    private Instant refundReqtime;
    private RefundStatus refundStatus;
    private String refundUserid;
}
