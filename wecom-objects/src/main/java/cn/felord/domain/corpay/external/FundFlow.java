package cn.felord.domain.corpay.external;

import cn.felord.enumeration.FundFlowType;
import cn.felord.enumeration.TransactionType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/6/29 16:42
 */
@Data
public class FundFlow {
    private Instant timestamp;
    private String requestNo;
    private TransactionType transactionType;
    private FundFlowType fundFlowType;
    private Long transactionAmount;
    private Long accountBalance;
    private String outTradeNo;
    private String mchId;
    private String operatorUserid;
    private List<GroupName> groupList;

}
