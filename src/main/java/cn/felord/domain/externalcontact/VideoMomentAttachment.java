package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentAttachmentType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class VideoMomentAttachment extends MomentAttachment {
    private final MediaId video;

    public VideoMomentAttachment(String mediaId) {
        super(MomentAttachmentType.VIDEO);
        this.video = new MediaId(mediaId);
    }
}
