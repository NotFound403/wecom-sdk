package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

/**
 * @author dax
 * @since 2022/11/24
 */
@Getter
public abstract class AbstractCard {
    private final TemplateCardType cardType;
    private final String taskId;
    private final MainTitle mainTitle;
    private final CardSource source;


    public AbstractCard(TemplateCardType cardType, String taskId, MainTitle mainTitle,CardSource source) {
        this.cardType = cardType;
        this.taskId = taskId;
        this.mainTitle = mainTitle;
        this.source = source;
    }

}
