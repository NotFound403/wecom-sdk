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
public class TextKfMessageRequest extends KfMessageRequest {
    private final KfMessageText text;


    public TextKfMessageRequest(String touser, String openKfid, KfMessageText text) {
        this(touser, openKfid, null, text);
    }

    public TextKfMessageRequest(String touser, String openKfid, String msgid, KfMessageText text) {
        super(touser, openKfid, msgid, KfMsgType.TEXT);
        this.text = text;
    }

}
