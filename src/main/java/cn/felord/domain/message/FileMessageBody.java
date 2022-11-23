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
public class FileMessageBody implements MessageBody {
    private final String msgtype = "file";
    private final String agentid;
    private final MediaId file;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected FileMessageBody(String agentid, MediaId file) {
        this.agentid = agentid;
        this.file = file;
    }


}
