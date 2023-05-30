/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalNotifyType;
import cn.felord.enumeration.UseTemplateApprover;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * todo
 *
 * @author dax
 * @since 2023 /5/25
 */
@Data
public class ApprovalApplyRequest {
    private final String creatorUserid;
    private final String templateId;
    private final UseTemplateApprover useTemplateApprover;
    private Long chooseDepartment;
    private List<Approver> approver;
    private List<String> notifyer;
    private ApprovalNotifyType notifyType;
    private final ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData;
    private final List<Summary> summaryList;


    /**
     * 通过接口指定审批人，不抄送
     *
     * @param creatorUserid the creator userid
     * @param templateId    the template id
     * @param approver      the approver
     * @param applyData     the apply data
     * @param summaryList   the summary list
     * @return the approval apply request
     */
    public static ApprovalApplyRequest approverMode(String creatorUserid,
                                                    String templateId,
                                                    List<Approver> approver,
                                                    ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                                    List<Summary> summaryList) {

        return approverMode(creatorUserid, templateId, approver, Collections.emptyList(), null, applyData, summaryList);
    }

    /**
     * 在企微控制台指定审批人、抄送人
     *
     * @param creatorUserid the creator userid
     * @param templateId    the template id
     * @param approver      the approver
     * @param notifyer      the notifyer
     * @param notifyType    the notify type
     * @param applyData     the apply data
     * @param summaryList   the summary list
     * @return the approval apply request
     */
    public static ApprovalApplyRequest approverMode(String creatorUserid,
                                                    String templateId,
                                                    List<Approver> approver,
                                                    List<String> notifyer,
                                                    ApprovalNotifyType notifyType,
                                                    ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                                    List<Summary> summaryList) {
        ApprovalApplyRequest approvalApplyRequest = new ApprovalApplyRequest(creatorUserid, templateId, UseTemplateApprover.APPROVER_MODE, applyData, summaryList);
        approvalApplyRequest.setApprover(approver);
        approvalApplyRequest.setNotifyer(notifyer);
        approvalApplyRequest.setNotifyType(notifyType);
        return approvalApplyRequest;
    }

    /**
     * 在企微控制台指定抄送人、审批人
     *
     * @param creatorUserid the creator userid
     * @param templateId    the template id
     * @param applyData     the apply data
     * @param summaryList   the summary list
     * @return the approval apply request
     */
    public static ApprovalApplyRequest backendMode(String creatorUserid,
                                                   String templateId,
                                                   ApplyData<ApprovalContentData<? extends ContentDataValue>> applyData,
                                                   List<Summary> summaryList) {
        return new ApprovalApplyRequest(creatorUserid, templateId, UseTemplateApprover.BACKEND_MODE, applyData, summaryList);
    }

}
