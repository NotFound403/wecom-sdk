package cn.felord.domain.message;

import cn.felord.domain.externalcontact.MediaId;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Builder
public class ImageMessageBody extends MessageBody {
    private final MediaId image;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public ImageMessageBody(String agentid, MediaId image) {
        super("image", agentid);
        this.image = image;
    }
}
