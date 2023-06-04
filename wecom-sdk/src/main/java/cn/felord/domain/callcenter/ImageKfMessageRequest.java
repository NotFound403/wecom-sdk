package cn.felord.domain.callcenter;

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class ImageKfMessageRequest extends KfMessageRequest {
    private final MediaId image;


    public ImageKfMessageRequest(String touser, String openKfid,  MediaId image) {
        this(touser, openKfid, null, image);
    }

    public ImageKfMessageRequest(String touser, String openKfid, String msgid,  MediaId image) {
        super(touser, openKfid, msgid, KfMsgType.IMAGE);
        this.image = image;
    }
}
