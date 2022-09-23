package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgAttachType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class LinkMsgAttachment extends MsgAttachment {
    private final Link link;
    public LinkMsgAttachment(Link link) {
        super(MsgAttachType.LINK);
        this.link =link;
    }
}
