package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ChatType;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@Data
public class MsgTemplateRequest {
    private final ChatType type;
    private Set<String> externalUserid;
    private String sender;
    private Text text;
    private Set<? extends MsgAttachment> attachments;
}
