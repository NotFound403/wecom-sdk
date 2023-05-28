package cn.felord.domain.message;

import cn.felord.domain.externalcontact.MediaId;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@Getter
public class VoiceMessageBody extends AbstractMessageBody {
    private final MediaId voice;

    protected VoiceMessageBody(String touser, String toparty, String totag, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MediaId voice) {
        super("voice", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.voice = voice;
    }

    public static class Builder {
        private final MediaId voice;
        private String touser;
        private String toparty;
        private String totag;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MediaId voice) {
            this.voice = voice;
        }

        public Builder touser(String touser) {
            this.touser = touser;
            return this;
        }

        public Builder toparty(String toparty) {
            this.toparty = toparty;
            return this;
        }

        public Builder totag(String totag) {
            this.totag = totag;
            return this;
        }

        public Builder enableDuplicateCheck(BoolEnum enableDuplicateCheck) {
            this.enableDuplicateCheck = enableDuplicateCheck;
            return this;
        }

        public Builder duplicateCheckInterval(Integer duplicateCheckInterval) {
            this.duplicateCheckInterval = duplicateCheckInterval;
            return this;
        }

        public VoiceMessageBody build() {
            return new VoiceMessageBody(touser, toparty, totag, enableDuplicateCheck, duplicateCheckInterval, voice);
        }

    }
}
