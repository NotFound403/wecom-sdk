package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * The type Miniprogram message body.
 *
 * @author felord
 * @since 2022 /11/22 16:07
 */
@Getter
public class MiniprogramMessageBody extends AbstractMessageBody {

    private final MiniprogramNotice miniprogramNotice;
    private final BoolEnum enableIdTrans;

    protected MiniprogramMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MiniprogramNotice miniprogramNotice) {
        super("miniprogram_notice", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.miniprogramNotice = miniprogramNotice;
        this.enableIdTrans = enableIdTrans;
    }

    public static class Builder {
        private final MiniprogramNotice miniprogramNotice;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MiniprogramNotice miniprogramNotice) {
            this.miniprogramNotice = miniprogramNotice;
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

        public MiniprogramMessageBody build() {
            return new MiniprogramMessageBody(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, miniprogramNotice);
        }

    }
}
