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
public class FileKfMessageRequest extends KfMessageRequest {
    private final MediaId file;


    public FileKfMessageRequest(String touser, String openKfid, MediaId file) {
        this(touser, openKfid, null, file);
    }

    public FileKfMessageRequest(String touser, String openKfid, String msgid, MediaId file) {
        super(touser, openKfid, msgid, KfMsgType.FILE);
        this.file = file;
    }
}
