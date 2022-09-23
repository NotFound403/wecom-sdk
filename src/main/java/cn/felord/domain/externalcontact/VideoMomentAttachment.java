package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentAttachmentType;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@Getter
public class VideoMomentAttachment extends MomentAttachment {
    private final MediaId video;

    public VideoMomentAttachment(MediaId video) {
        super(MomentAttachmentType.VIDEO);
        this.video = video;
    }
}
