package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardAction;
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.HorizontalContent;
import cn.felord.domain.webhook.card.Jump;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.QuoteArea;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

import java.util.List;

/**
 * The type Message template card.
 *
 * @author felord
 * @since 2022 /11/23 9:16
 */

@Getter
public abstract class MessageTemplateCard extends AbstractCard {

    private final ActionMenu actionMenu;
    private final QuoteArea quoteArea;
    private final List<? extends HorizontalContent> horizontalContentList;
    private final List<? extends Jump> jumpList;
    private final CardAction cardAction;

    public MessageTemplateCard(TemplateCardType cardType, String taskId, MainTitle mainTitle,
                               CardSource source, ActionMenu actionMenu, QuoteArea quoteArea,
                               List<? extends HorizontalContent> horizontalContentList, List<? extends Jump> jumpList, CardAction cardAction) {
        super(cardType, taskId, mainTitle,source);
        this.actionMenu = actionMenu;
        this.quoteArea = quoteArea;
        this.horizontalContentList = horizontalContentList;
        this.jumpList = jumpList;
        this.cardAction = cardAction;
    }
}
