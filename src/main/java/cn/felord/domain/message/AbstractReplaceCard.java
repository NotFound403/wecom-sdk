package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/11/24
 */
@Getter
public abstract class AbstractReplaceCard {
    private final TemplateCardType cardType;
    private final MainTitle mainTitle;
    private final CardSource source;


    public AbstractReplaceCard(TemplateCardType cardType, MainTitle mainTitle, CardSource source) {
        this.cardType = cardType;
        this.mainTitle = mainTitle;
        this.source = source;
    }

}
