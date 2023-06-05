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
public abstract class KfEventMessageRequest {
    private final String code;
    private final String msgid;
    private final KfMsgType msgtype;


    public KfEventMessageRequest(String code, String msgid, KfMsgType msgtype) {
        this.code = code;
        this.msgid = msgid;
        this.msgtype = msgtype;
    }
}
