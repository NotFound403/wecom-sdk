package cn.felord.domain.message;

import cn.felord.domain.externalcontact.MediaId;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class ImageMessageBody implements MessageBody {
    private final String msgtype = "image";
    private final String agentid;
    private final MediaId image;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected ImageMessageBody(String agentid, MediaId image) {
        this.agentid = agentid;
        this.image = image;
    }
}
