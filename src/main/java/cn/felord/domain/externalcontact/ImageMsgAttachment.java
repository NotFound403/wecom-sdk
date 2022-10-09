package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgAttachType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class ImageMsgAttachment extends MsgAttachment {
   private final Image image;

    public ImageMsgAttachment(Image image) {
        super(MsgAttachType.IMAGE);
        this.image = image;
    }

}
