package cn.felord.domain.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author felord
 * @since 2022/11/22 17:25
 */
@Setter
@Getter
public class MpNewsArticle extends MessageArticle {

    private final String thumbMediaId;
    private String author;
    private String contentSourceUrl;
    private String content;
    private String digest;

    public MpNewsArticle(String title, String thumbMediaId) {
        super(title);
        this.thumbMediaId = thumbMediaId;
    }
}
