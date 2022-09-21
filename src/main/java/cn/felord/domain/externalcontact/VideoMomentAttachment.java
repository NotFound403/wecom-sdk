package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentAttachmentType;
import lombok.Data;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@Getter
public class VideoMomentAttachment extends MomentAttachment {
    private final Video video;

    public VideoMomentAttachment(Video video) {
        super(MomentAttachmentType.VIDEO);
        this.video = video;
    }

    @Data
    public static class Video {
        private final String mediaId;
    }
}
