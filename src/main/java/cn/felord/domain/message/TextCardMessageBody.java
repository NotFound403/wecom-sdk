package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Builder
public class TextCardMessageBody extends MessageBody {
    private final MessageTextCard textcard;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public TextCardMessageBody(String agentid, MessageTextCard textcard) {
        super("textcard", agentid);
        this.textcard = textcard;
    }
}
