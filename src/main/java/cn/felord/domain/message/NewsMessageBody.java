package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Builder;

/**
 * @author felord
 * @since 2022/11/22 17:22
 */
@Builder
public class NewsMessageBody extends MessageBody {
    private final MessageNews<NewsArticle> news;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    public NewsMessageBody(String agentid, MessageNews<NewsArticle> news) {
        super("news", agentid);
        this.news = news;
    }
}
