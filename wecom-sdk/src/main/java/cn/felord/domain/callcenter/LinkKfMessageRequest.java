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
public class LinkKfMessageRequest extends KfMessageRequest {
    private final KfMessageLink link;


    public LinkKfMessageRequest(String touser, String openKfid, KfMessageLink link) {
        this(touser, openKfid, null, link);
    }

    public LinkKfMessageRequest(String touser, String openKfid, String msgid, KfMessageLink link) {
        super(touser, openKfid, msgid, KfMsgType.LINK);
        this.link = link;
    }

}
