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
public class VideoMsgAttachment extends MsgAttachment {
    private final MediaId video;

    public VideoMsgAttachment(MediaId video) {
        super(MsgAttachType.VIDEO);
        this.video = video;
    }
}
