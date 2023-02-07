package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@Getter
public class VideoMessageBody extends AbstractMessageBody {
    private final MessageVideo video;

    protected VideoMessageBody(String touser, String toparty, String totag, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MessageVideo video) {
        super("video", touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval);
        this.video = video;
    }

    public static class Builder {
        private final MessageVideo video;
        private String touser;
        private String toparty;
        private String totag;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MessageVideo video) {
            this.video = video;
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

        public Builder safe(MessageSafe safe) {
            this.safe = safe;
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

        public VideoMessageBody build() {
            return new VideoMessageBody(touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval, video);
        }

    }
}
