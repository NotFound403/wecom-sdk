
package cn.felord.domain.callcenter;

import lombok.Data;

@Data
public class KfCorpStatisticDetail {

    private Long aiKnowledgeHitRate;
    private Long aiSessionReplyCnt;
    private Long aiTransferRate;
    private Long customerCnt;
    private Long customerMsgCnt;
    private Long msgRejectedCustomerCnt;
    private Long sessionCnt;
    private Long upgradeServiceCustomerCnt;
}
