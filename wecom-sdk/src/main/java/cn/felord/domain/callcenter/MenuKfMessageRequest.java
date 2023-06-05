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
public class MenuKfMessageRequest extends KfMessageRequest {
    private final KfMsgMenu msgmenu;


    public MenuKfMessageRequest(String touser, String openKfid, KfMsgMenu msgmenu) {
        this(touser, openKfid, null, msgmenu);
    }

    public MenuKfMessageRequest(String touser, String openKfid, String msgid, KfMsgMenu msgmenu) {
        super(touser, openKfid, msgid, KfMsgType.MSG_MENU);
        this.msgmenu = msgmenu;
    }

}
