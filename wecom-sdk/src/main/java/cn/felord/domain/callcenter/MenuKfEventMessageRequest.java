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
public class MenuKfEventMessageRequest extends KfEventMessageRequest {
    private final KfMsgMenu msgmenu;

    public MenuKfEventMessageRequest(String touser,  KfMsgMenu msgmenu) {
        this(touser, null, msgmenu);
    }

    public MenuKfEventMessageRequest(String touser, String msgid,  KfMsgMenu msgmenu) {
        super(touser, msgid, KfMsgType.TEXT);
        this.msgmenu = msgmenu;
    }
}
