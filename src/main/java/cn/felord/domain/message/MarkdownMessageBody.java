package cn.felord.domain.message;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Builder
public class MarkdownMessageBody extends MessageBody {
    private final ContentText markdown;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public MarkdownMessageBody(String agentid, ContentText markdown) {
        super("markdown", agentid);
        this.markdown = markdown;
    }
}
