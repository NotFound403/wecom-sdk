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
public class TextKfEventMessageRequest extends KfEventMessageRequest {
    private final KfMessageText text;


    public TextKfEventMessageRequest(String touser, KfMessageText text) {
        this(touser, null, text);
    }

    public TextKfEventMessageRequest(String touser, String msgid, KfMessageText text) {
        super(touser, msgid, KfMsgType.TEXT);
        this.text = text;
    }
}
