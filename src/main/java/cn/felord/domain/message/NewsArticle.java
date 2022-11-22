package cn.felord.domain.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author felord
 * @since 2022/11/22 17:25
 */
@Setter
@Getter
public class NewsArticle extends MessageArticle {

    private String description;
    private String url;
    private String picurl;
    private String appid;
    private String pagepath;

    public NewsArticle(String title) {
        super(title);
    }
}
