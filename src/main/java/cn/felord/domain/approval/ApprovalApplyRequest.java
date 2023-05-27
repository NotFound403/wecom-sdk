package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalNotifyType;
import cn.felord.enumeration.UseTemplateApprover;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25
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
    private final ApplyData<TemplateContentData<?>> applyData;
    private final List<Summary> summaryList;

}
