package cn.felord.payment.wechat.v3.domain.payscore;

import cn.felord.payment.wechat.enumeration.PayScoreOrderState;
import cn.felord.payment.wechat.enumeration.StateDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * The type Pay score order response.
 */
@Data
public class PayScoreOrderResponse {
    private String outOrderNo;
    private String appid;
    private String serviceId;
    private List<PostPayment> postPayments;
    private List<PostDiscount> postDiscounts;
    private TimeRange timeRange;
    private Location location;
    private String serviceIntroduction;
    private RiskFund riskFund;
    private String attach;
    private String notifyUrl;
    private PayScoreOrderState state;
    private StateDescription stateDescription;
    private String orderId;
    @JsonProperty("package")
    private String pkg;
}