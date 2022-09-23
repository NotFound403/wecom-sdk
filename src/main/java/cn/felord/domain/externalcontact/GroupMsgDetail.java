package cn.felord.domain.externalcontact;

import cn.felord.enumeration.CreateType;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/22 16:26
 */
@Data
public class GroupMsgDetail {
     private String msgid;
     private String creator;
     private Instant createTime;
     private CreateType createType;
     private Text text;
     private Set<? extends MsgAttachment> attachments;
}
