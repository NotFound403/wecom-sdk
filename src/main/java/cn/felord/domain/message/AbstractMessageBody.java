package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * The type Message body.
 *
 * @author felord
 * @since 2021 /11/22 16:01
 */
@Getter
public abstract class AbstractMessageBody {
    private final String msgtype;
    private String agentid;
    private final String touser;
    private final String toparty;
    private final String totag;
    private final MessageSafe safe;
    private final BoolEnum enableDuplicateCheck;
    private final Integer duplicateCheckInterval;

    public AbstractMessageBody(String msgtype, String touser, String toparty, String totag, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval) {
        this.msgtype = msgtype;
        this.touser = touser;
        this.toparty = toparty;
        this.totag = totag;
        this.safe = safe;
        this.enableDuplicateCheck = enableDuplicateCheck;
        this.duplicateCheckInterval = duplicateCheckInterval;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }
}
