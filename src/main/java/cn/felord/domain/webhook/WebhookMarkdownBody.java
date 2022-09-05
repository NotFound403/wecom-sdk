package cn.felord.domain.webhook;

import cn.felord.enumeration.MsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class WebhookMarkdownBody extends WebhookBody {
    private WebhookMarkdown markdown;

    public WebhookMarkdownBody() {
        super(MsgType.MARKDOWN);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookMarkdown {
        private String content;
    }

}
