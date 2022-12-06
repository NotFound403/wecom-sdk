package cn.felord.domain.webhook;

import cn.felord.domain.webhook.card.TemplateCard;
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
public class WebhookTemplateCardBody extends WebhookBody {
    private final TemplateCard templateCard;

    /**
     * Instantiates a new Webhook template card body.
     */
    public <T extends TemplateCard> WebhookTemplateCardBody(T templateCard) {
        super(HookMsgType.TEMPLATE_CARD);
        this.templateCard = templateCard;
    }
}
