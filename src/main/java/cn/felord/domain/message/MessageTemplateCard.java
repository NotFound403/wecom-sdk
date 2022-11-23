package cn.felord.domain.message;

import cn.felord.domain.webhook.card.*;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type Message template card.
 *
 * @author felord
 * @since 2022 /11/23 9:16
 */
@Setter
@Getter
public abstract class MessageTemplateCard {
    private final TemplateCardType cardType;
    private final String taskId;
    private CardSource source;
    private ActionMenu actionMenu;
    private MainTitle mainTitle;
    private QuoteArea quoteArea;
    private List<? extends HorizontalContent> horizontalContentList;
    private List<? extends Jump> jumpList;
    private CardAction cardAction;

    /**
     * Instantiates a new Message template card.
     *
     * @param cardType the card type
     * @param taskId   the task id
     */
    protected MessageTemplateCard(TemplateCardType cardType, String taskId) {
        this(cardType, taskId, null, null);
    }

    /**
     * Instantiates a new Message template card.
     *
     * @param cardType  the card type
     * @param taskId    the task id
     * @param mainTitle the main title
     */
    protected MessageTemplateCard(TemplateCardType cardType, String taskId, MainTitle mainTitle) {
        this(cardType, taskId, mainTitle, null);
    }

    /**
     * Instantiates a new Message template card.
     *
     * @param cardType   the card type
     * @param taskId     the task id
     * @param cardAction the card action
     */
    protected MessageTemplateCard(TemplateCardType cardType, String taskId, CardAction cardAction) {
        this(cardType, taskId, null, cardAction);
    }

    /**
     * Instantiates a new Message template card.
     *
     * @param cardType   the card type
     * @param taskId     the task id
     * @param mainTitle  the main title
     * @param cardAction the card action
     */
    protected MessageTemplateCard(TemplateCardType cardType, String taskId, MainTitle mainTitle, CardAction cardAction) {
        this.cardType = cardType;
        this.taskId = taskId;
        this.mainTitle = mainTitle;
        this.cardAction = cardAction;
    }
}
