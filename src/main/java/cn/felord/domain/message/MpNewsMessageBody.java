package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 17:22
 */
@Builder
public class MpNewsMessageBody extends MessageBody {
    private final MessageNews<MpNewsArticle> mpnews;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public MpNewsMessageBody(String agentid, MessageNews<MpNewsArticle> mpnews) {
        super("mpnews", agentid);
        this.mpnews = mpnews;
    }
}
