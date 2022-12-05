package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ChatType;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@Data
public class MsgTemplateRequest {
    private final ChatType type;
    private List<String> externalUserid;
    private String sender;
    private Boolean allowSelect;
    private ContentText text;
    private List<? extends MsgAttachment> attachments;
}
