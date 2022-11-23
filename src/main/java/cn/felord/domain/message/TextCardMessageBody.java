package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class TextCardMessageBody implements MessageBody {
    private final String msgtype = "textcard";
    private final String agentid;
    private final MessageTextCard textcard;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected TextCardMessageBody(String agentid, MessageTextCard textcard) {
        this.agentid = agentid;
        this.textcard = textcard;
    }
}
