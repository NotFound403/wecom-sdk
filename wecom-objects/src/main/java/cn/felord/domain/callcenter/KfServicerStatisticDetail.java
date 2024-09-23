
/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
