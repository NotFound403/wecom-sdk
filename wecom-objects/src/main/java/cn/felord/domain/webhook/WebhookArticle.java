package cn.felord.domain.webhook;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The type Webhook article.
 *
 * @author dax
 * @since 2023 /10/6
 */
@ToString
@Getter
@RequiredArgsConstructor
public class WebhookArticle {
    private final String title;
    private final String url;
    private String description;
    private String picurl;

    /**
     * Description webhook article.
     *
     * @param description the description
     * @return the webhook article
     */
    public WebhookArticle description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Picurl webhook article.
     *
     * @param picurl the picurl
     * @return the webhook article
     */
    public WebhookArticle picurl(String picurl) {
        this.picurl = picurl;
        return this;
    }
}
