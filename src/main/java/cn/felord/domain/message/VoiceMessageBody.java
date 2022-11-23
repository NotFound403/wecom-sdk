
package cn.felord.domain.message;

import cn.felord.domain.externalcontact.MediaId;
import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class VoiceMessageBody implements MessageBody {
    private final String msgtype = "voice";
    private final String agentid;
    private final MediaId voice;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected VoiceMessageBody(String agentid, MediaId voice) {
        this.agentid = agentid;
        this.voice = voice;
    }
}
