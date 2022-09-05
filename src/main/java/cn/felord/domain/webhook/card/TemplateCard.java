package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author felord.cn
 * @since 2021/9/3 15:47
 */
@Setter
@Getter
public abstract class TemplateCard {
    private final CardType cardType;
    private CardSource source;
    private final MainTitle mainTitle;
    private  QuoteArea quoteArea;
    private List<? extends HorizontalContent> horizontalContentList;
    private List<? extends Jump> jumpList;
    private final CardAction cardAction;



    protected TemplateCard(CardType cardType, MainTitle mainTitle, CardAction cardAction) {
        this.cardType = cardType;
        this.mainTitle = mainTitle;
        this.cardAction = cardAction;
    }
}
