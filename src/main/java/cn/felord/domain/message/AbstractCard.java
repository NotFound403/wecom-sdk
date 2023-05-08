package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

/**
 * The type Abstract card.
 *
 * @author dax
 * @see TemplateCardBuilders
 * @since 2021 /11/24
 */
@Getter
public abstract class AbstractCard {
    private final TemplateCardType cardType;
    private final String taskId;
    private final MainTitle mainTitle;
    private final CardSource source;


    /**
     * Instantiates a new Abstract card.
     *
     * @param cardType  the card type
     * @param taskId    the task id
     * @param mainTitle the main title
     * @param source    the source
     */
    public AbstractCard(TemplateCardType cardType, String taskId, MainTitle mainTitle, CardSource source) {
        this.cardType = cardType;
        this.taskId = taskId;
        this.mainTitle = mainTitle;
        this.source = source;
    }

}
