package cn.felord.domain.webhook;

import cn.felord.enumeration.MsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WebhookMarkdownBody extends WebhookBody {
    private WebhookMarkdown markdown;

    public WebhookMarkdownBody() {
        setMsgtype(MsgType.MARKDOWN);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookMarkdown {
        private String content;
    }

}
