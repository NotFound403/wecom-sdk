package cn.felord.domain.message;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class MarkdownMessageBody implements MessageBody {
    private final String msgtype = "markdown";
    private final String agentid;
    private final ContentText markdown;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected MarkdownMessageBody(String agentid, ContentText markdown) {
        this.agentid = agentid;
        this.markdown = markdown;
    }
}
