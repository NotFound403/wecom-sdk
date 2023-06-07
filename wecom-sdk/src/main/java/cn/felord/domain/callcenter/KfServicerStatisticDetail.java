
package cn.felord.domain.callcenter;

import lombok.Data;

@Data
public class KfServicerStatisticDetail {

    private Long customerCnt;
    private Long customerMsgCnt;
    private Long dissatisfiedRate;
    private Long firstReplyAverageSec;
    private Long middlingRate;
    private Long msgRejectedCustomerCnt;
    private Long replyRate;
    private Long satisfactionInvestgateCnt;
    private Long satisfactionParticipationRate;
    private Long satisfiedRate;
    private Long sessionCnt;
    private Long upgradeServiceCustomerCnt;
    private Long upgradeServiceGroupchatCustomerCnt;
    private Long upgradeServiceGroupchatInviteCnt;
    private Long upgradeServiceMemberCustomerCnt;
    private Long upgradeServiceMemberInviteCnt;

}
