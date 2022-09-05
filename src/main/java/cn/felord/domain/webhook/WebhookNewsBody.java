package cn.felord.domain.webhook;

import cn.felord.enumeration.MsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class WebhookNewsBody extends WebhookBody {
    private WebhookNews news;

    public WebhookNewsBody() {
        super(MsgType.NEWS);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookNews {
        private List<WebhookArticle> articles;
    }

    /**
     * The type Article.
     */
    @Data
    public static class WebhookArticle {
        private String title;
        private String description;
        private String url;
        private String picurl;
    }
}
