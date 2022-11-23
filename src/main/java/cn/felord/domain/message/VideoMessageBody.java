package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class VideoMessageBody implements MessageBody {
    private final String msgtype = "video";
    private final String agentid;
    private final MessageVideo video;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected VideoMessageBody(String agentid, MessageVideo video) {
        this.agentid = agentid;
        this.video = video;
    }
}
