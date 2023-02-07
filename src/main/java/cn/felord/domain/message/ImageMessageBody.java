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
public class ImageMessageBody extends AbstractMessageBody {
    private final MediaId image;

    protected ImageMessageBody(String touser, String toparty, String totag, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MediaId image) {
        super("image", touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval);
        this.image = image;
    }

    public static class Builder {
        private final MediaId file;
        private String touser;
        private String toparty;
        private String totag;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;


        protected Builder(MediaId file) {
            this.file = file;
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

        public ImageMessageBody build() {
            return new ImageMessageBody(touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval, file);
        }

    }
}
