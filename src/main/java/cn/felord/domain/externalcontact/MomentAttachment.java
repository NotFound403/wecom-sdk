package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentAttachmentType;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/23 15:12
 */
@Data
public abstract class MomentAttachment {
    private final MomentAttachmentType msgtype;
}
