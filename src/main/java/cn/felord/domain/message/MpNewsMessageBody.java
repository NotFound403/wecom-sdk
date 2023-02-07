package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 17:22
 */
@Getter
public class MpNewsMessageBody extends AbstractMessageBody {
    private final MessageNews<MpNewsArticle> mpnews;
    private final BoolEnum enableIdTrans;

    protected MpNewsMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MessageNews<MpNewsArticle> mpnews) {
        super("mpnews", touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval);
        this.mpnews = mpnews;
        this.enableIdTrans = enableIdTrans;
    }

    public static class Builder {
        private final MessageNews<MpNewsArticle> mpnews;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MessageNews<MpNewsArticle> mpnews) {
            this.mpnews = mpnews;
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

        public Builder enableIdTrans(BoolEnum enableIdTrans) {
            this.enableIdTrans = enableIdTrans;
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

        public MpNewsMessageBody build() {
            return new MpNewsMessageBody(touser, toparty, totag, enableIdTrans, safe, enableDuplicateCheck, duplicateCheckInterval, mpnews);
        }

    }
}
