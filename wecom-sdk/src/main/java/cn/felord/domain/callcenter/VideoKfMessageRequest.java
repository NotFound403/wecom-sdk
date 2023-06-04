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
public class VideoKfMessageRequest extends KfMessageRequest {
    private final MediaId video;


    public VideoKfMessageRequest(String touser, String openKfid, MediaId video) {
        this(touser, openKfid, null, video);
    }

    public VideoKfMessageRequest(String touser, String openKfid, String msgid, MediaId video) {
        super(touser, openKfid, msgid, KfMsgType.VIDEO);
        this.video = video;
    }
}
