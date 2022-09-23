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
public class FileMsgAttachment extends MsgAttachment {
    private final MediaId file;

    public FileMsgAttachment(MediaId file) {
        super(MsgAttachType.FILE);
        this.file = file;
    }
}
