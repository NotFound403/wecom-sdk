package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 17:22
 */
@Getter
public class NewsMessageBody extends AbstractMessageBody {
    private final MessageNews<NewsArticle> news;
    private final BoolEnum enableIdTrans;


    protected NewsMessageBody(String touser, String toparty, String totag, BoolEnum enableIdTrans, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval, MessageNews<NewsArticle> news) {
        super("news", touser, toparty, totag, null, enableDuplicateCheck, duplicateCheckInterval);
        this.news = news;
        this.enableIdTrans = enableIdTrans;
    }

    public static class Builder {
        private final MessageNews<NewsArticle> news;
        private String touser;
        private String toparty;
        private String totag;
        private BoolEnum enableIdTrans;
        private BoolEnum enableDuplicateCheck;
        private Integer duplicateCheckInterval;

        protected Builder(MessageNews<NewsArticle> news) {
            this.news = news;
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

        public NewsMessageBody build() {
            return new NewsMessageBody(touser, toparty, totag, enableIdTrans, enableDuplicateCheck, duplicateCheckInterval, news);
        }

    }
}
