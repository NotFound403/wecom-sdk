package cn.felord.domain.message;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@Getter
public class TextMessageBody extends AbstractMessageBody {

    private final ContentText text;
    private final BoolEnum enableIdTrans;


    protected TextMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, ContentText text) {
        super("text", touser, toparty, totag, safe, enableDuplicateCheck, duplicateCheckInterval);
        this.text = text;
        this.enableIdTrans = enableIdTrans;
    }


    public static class Builder {
        private final ContentText text;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private MessageSafe safe;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(ContentText text) {
            this.text = text;
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

        public TextMessageBody build() {
            return new TextMessageBody(touser, toparty, totag, enableIdTrans, safe, enableDuplicateCheck, duplicateCheckInterval, text);
        }

    }
}
