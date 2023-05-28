package cn.felord.domain.callback;

import cn.felord.enumeration.SpStatus;
import cn.felord.enumeration.StatusChangeEvent;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/27
 */
@Data
public class ApprovalInfo {
    @XStreamAlias("SpNo")
    private String spNo;
    @XStreamAlias("SpName")
    private String spName;
    @XStreamAlias("SpStatus")
    private SpStatus spStatus;
    @XStreamAlias("TemplateId")
    private String templateId;
    @XStreamAlias("ApplyTime")
    private Instant applyTime;
    @XStreamAlias("Applyer")
    private Applyer applyer;
    @XStreamImplicit(itemFieldName = "SpRecord")
    private List<SpRecord> spRecord;
    @XStreamAlias("Notifyer")
    private CallbackUserId notifyer;
    @XStreamAlias("Comments")
    private Comments comments;
    @XStreamAlias("StatuChangeEvent")
    private StatusChangeEvent statuChangeEvent;
}
