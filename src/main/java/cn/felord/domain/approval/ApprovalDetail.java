package cn.felord.domain.approval;

import cn.felord.domain.common.DeptUserMap;
import cn.felord.domain.common.UserId;
import cn.felord.enumeration.SpStatus;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/27 14:48
 */
@Data
public class ApprovalDetail {
    private String spNo;
    private String spName;
    private SpStatus spStatus;
    private String templateId;
    private Instant applyTime;
    private DeptUserMap applyer;
    private List<SpRecordItem> spRecord;
    private List<UserId> notifyer;
    private ApplyData<ApplyContentData<?>> applyData;
    private List<ApprovalComment> comments;
}
