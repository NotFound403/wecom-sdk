
package cn.felord.domain.message;

import cn.felord.domain.externalcontact.MediaId;
import cn.felord.enumeration.BoolEnum;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Builder
public class VoiceMessageBody extends MessageBody {
    private final MediaId voice;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public VoiceMessageBody(String agentid, MediaId voice) {
        super("voice", agentid);
        this.voice = voice;
    }
}
