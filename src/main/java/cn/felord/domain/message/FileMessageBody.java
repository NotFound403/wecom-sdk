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
public class FileMessageBody extends MessageBody {
    private final MediaId file;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public FileMessageBody(String agentid, MediaId file) {
        super("file", agentid);
        this.file = file;
    }
}
