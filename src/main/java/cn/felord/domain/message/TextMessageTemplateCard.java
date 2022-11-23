package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardAction;
import cn.felord.domain.webhook.card.EmphasisContent;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

/**
 * The type Text message template card.
 *
 * @author felord
 * @since 2022 /11/23 11:35
 */
@Getter
public class TextMessageTemplateCard extends MessageTemplateCard {
    private EmphasisContent emphasisContent;
    private String subTitleText;

    /**
     * Instantiates a new Text message template card.
     *
     * @param taskId     the task id
     * @param cardAction the card action
     */
    public TextMessageTemplateCard(String taskId, CardAction cardAction) {
        super(TemplateCardType.TEXT_NOTICE, taskId, cardAction);
    }
}
