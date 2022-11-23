package cn.felord.domain.message;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class TextMessageBody implements MessageBody {
    private final String msgtype = "text";
    private final String agentid;
    private final ContentText text;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected TextMessageBody(String agentid, ContentText text) {
        this.agentid = agentid;
        this.text = text;
    }
}
