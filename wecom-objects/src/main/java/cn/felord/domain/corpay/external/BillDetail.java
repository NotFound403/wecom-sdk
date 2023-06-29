
package cn.felord.domain.corpay.external;

import cn.felord.enumeration.BillType;
import cn.felord.enumeration.PaymentType;
import cn.felord.enumeration.TradeState;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/6/29 16:20
 */
@Data
public class BillDetail {

    private String transactionId;
    private BillType billType;
    private TradeState tradeState;
    private Instant payTime;
    private String outTradeNo;
    private String outRefundNo;
    private String externalUserid;
    private Long totalFee;
    private String payeeUserid;
    private PaymentType paymentType;
    private String mchId;
    private String remark;
    private List<Commodity> commodityList;
    private Long totalRefundFee;
    private List<RefundInfo> refundList;
    private ContactInfo contactInfo;
    private MiniprogramInfo miniprogramInfo;

}
