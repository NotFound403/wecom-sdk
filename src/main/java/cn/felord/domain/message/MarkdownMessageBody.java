package cn.felord.domain.message;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 16:07
 */
@Getter
public class MarkdownMessageBody extends AbstractMessageBody {
    private final String msgtype = "markdown";
    private final ContentText markdown;

    protected MarkdownMessageBody(String touser, String toparty, String totag, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, ContentText markdown) {
        super("markdown", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.markdown = markdown;
    }

    public static class Builder {
        private final ContentText markdown;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;


        protected Builder(ContentText markdown) {
            this.markdown = markdown;
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

        public MarkdownMessageBody build() {
            return new MarkdownMessageBody(touser, toparty, totag, enableDuplicateCheck, duplicateCheckInterval, markdown);
        }

    }
}
