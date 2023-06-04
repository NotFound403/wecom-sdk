package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public abstract class KfMessageRequest {
    private final String touser;
    private final String openKfid;
    private final String msgid;
    private final KfMsgType msgtype;


    public KfMessageRequest(String touser, String openKfid, String msgid, KfMsgType msgtype) {
        this.touser = touser;
        this.openKfid = openKfid;
        this.msgid = msgid;
        this.msgtype = msgtype;
    }
}
