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
public class ImageMomentAttachment extends MomentAttachment {
    private final MediaId image;

    public ImageMomentAttachment(String mediaId) {
        super(MomentAttachmentType.IMAGE);
        this.image = new MediaId(mediaId);
    }

}
