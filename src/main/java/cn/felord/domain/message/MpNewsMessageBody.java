package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 17:22
 */
@Getter
public class MpNewsMessageBody implements MessageBody {
    private final String msgtype = "mpnews";
    private final String agentid;
    private final MessageNews<MpNewsArticle> mpnews;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private MessageSafe safe;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected MpNewsMessageBody(String agentid, MessageNews<MpNewsArticle> mpnews) {
        this.agentid = agentid;
        this.mpnews = mpnews;
    }
}
