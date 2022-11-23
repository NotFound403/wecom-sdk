package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * @author felord
 * @since 2022/11/22 17:22
 */
@Getter
public class NewsMessageBody implements MessageBody {
    private final String msgtype = "news";
    private final String agentid;
    private final MessageNews<NewsArticle> news;
    private String touser;
    private String toparty;
    private String totag;
    private BoolEnum enableIdTrans;
    private BoolEnum enableDuplicateCheck;
    private Integer duplicateCheckInterval;

    protected NewsMessageBody(String agentid, MessageNews<NewsArticle> news) {
        this.agentid = agentid;
        this.news = news;
    }
}
