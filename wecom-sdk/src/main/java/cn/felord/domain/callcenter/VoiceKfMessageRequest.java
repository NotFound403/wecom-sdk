package cn.felord.domain.callcenter;

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class VoiceKfMessageRequest extends KfMessageRequest {
    private final MediaId voice;


    public VoiceKfMessageRequest(String touser, String openKfid, MediaId voice) {
        this(touser, openKfid, null, voice);
    }

    public VoiceKfMessageRequest(String touser, String openKfid, String msgid, MediaId voice) {
        super(touser, openKfid, msgid, KfMsgType.VOICE);
        this.voice = voice;
    }
}
