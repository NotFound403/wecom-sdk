package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MomentAttachmentType;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@Getter
public class ImageMomentAttachment extends MomentAttachment {
    private final MediaId image;

    public ImageMomentAttachment(MediaId image) {
        super(MomentAttachmentType.IMAGE);
        this.image = image;
    }

}
