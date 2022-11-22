package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Builder
public class VideoMessageBody extends MessageBody {
    private final MessageVideo video;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public VideoMessageBody(String agentid, MessageVideo video) {
        super("video", agentid);
        this.video = video;
    }
}
