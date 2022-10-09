package cn.felord.domain.webhook;

import cn.felord.domain.webhook.card.TemplateCard;
import cn.felord.enumeration.HookMsgType;
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
public class WebhookTemplateCardBody extends WebhookBody {
    private TemplateCard templateCard;

    /**
     * Instantiates a new Webhook template card body.
     */
    public WebhookTemplateCardBody() {
        super(HookMsgType.TEMPLATE_CARD);
    }
}
