package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 16:07
 */
@Getter
public class TextCardMessageBody extends AbstractMessageBody {

    private final MessageTextCard textcard;
    private final BoolEnum enableIdTrans;

    protected TextCardMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MessageTextCard textcard) {
        super("textcard", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.textcard = textcard;

        this.enableIdTrans = enableIdTrans;
    }


    public static class Builder {
        private final MessageTextCard textcard;
        private String touser;
        private String toparty;
        private String totag;
        private String btntxt;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MessageTextCard textcard) {
            this.textcard = textcard;
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

        public Builder enableDuplicateCheck(BoolEnum enableDuplicateCheck) {
            this.enableDuplicateCheck = enableDuplicateCheck;
            return this;
        }

        public Builder duplicateCheckInterval(Integer duplicateCheckInterval) {
            this.duplicateCheckInterval = duplicateCheckInterval;
            return this;
        }

        public TextCardMessageBody build() {
            return new TextCardMessageBody(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, textcard);
        }

    }
}
