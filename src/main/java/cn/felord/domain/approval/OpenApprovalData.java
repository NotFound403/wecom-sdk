
package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dax
 * @since 2023/5/19 22:23
 */
@Data
public class OpenApprovalData {
    @JsonProperty("ApplyTime")
    private Long applyTime;
    @JsonProperty("ApplyUserId")
    private String applyUserId;
    @JsonProperty("ApplyUserImage")
    private String applyUserImage;
    @JsonProperty("ApplyUserParty")
    private String applyUserParty;
    @JsonProperty("ApplyUsername")
    private String applyUsername;
    @JsonProperty("ApprovalNodes")
    private ApprovalNodes approvalNodes;
    @JsonProperty("ApproverStep")
    private Long approverStep;
    @JsonProperty("NotifyNodes")
    private NotifyNodes notifyNodes;
    @JsonProperty("OpenSpName")
    private String openSpName;
    @JsonProperty("OpenSpstatus")
    private Long openSpstatus;
    @JsonProperty("OpenTemplateId")
    private String openTemplateId;
    @JsonProperty("ThirdNo")
    private String thirdNo;
}
