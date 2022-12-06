package cn.felord.domain.webhook;

import cn.felord.domain.externalcontact.ContentText;
import cn.felord.enumeration.HookMsgType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class WebhookMarkdownBody extends WebhookBody {
    private final ContentText markdown;

    public WebhookMarkdownBody(ContentText markdown) {
        super(HookMsgType.MARKDOWN);
        this.markdown = markdown;
    }

}
