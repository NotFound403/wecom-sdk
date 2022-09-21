package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentAttachmentType;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@Getter
public class LinkMomentAttachment extends MomentAttachment {
    private final MomentLink link;

    public LinkMomentAttachment(MomentLink link) {
        super(MomentAttachmentType.LINK);
        this.link = link;
    }

}
