package cn.felord.domain.message;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Builder
public class TextMessageBody extends MessageBody {
    private final ContentText text;
    private String touser;
    private String toparty;
    private String totag;
    private MessageSafe safe;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public TextMessageBody(String agentid, ContentText text) {
        super("text", agentid);
        this.text = text;
    }
}
