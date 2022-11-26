package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardAction;
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.EmphasisContent;
import cn.felord.domain.webhook.card.HorizontalContent;
import cn.felord.domain.webhook.card.Jump;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.QuoteArea;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

import java.util.List;

/**
 * The type Text message template card.
 *
 * @author felord
 * @since 2022 /11/23 11:35
 */
@Getter
public class TextMessageTemplateCard extends MessageTemplateCard {
    private final EmphasisContent emphasisContent;
    private final String subTitleText;


    protected TextMessageTemplateCard(String taskId, MainTitle mainTitle, CardSource source,
                                      ActionMenu actionMenu, QuoteArea quoteArea,
                                      List<? extends HorizontalContent> horizontalContentList, List<? extends Jump> jumpList,
                                      CardAction cardAction, EmphasisContent emphasisContent, String subTitleText) {
        super(TemplateCardType.TEXT_NOTICE, taskId, mainTitle, source, actionMenu, quoteArea, horizontalContentList, jumpList, cardAction);
        this.emphasisContent = emphasisContent;
        this.subTitleText = subTitleText;
    }

    public static class Builder {
        private final String taskId;
        private final CardAction cardAction;
        private MainTitle mainTitle;
        private CardSource source;
        private ActionMenu actionMenu;
        private QuoteArea quoteArea;
        private List<? extends HorizontalContent> horizontalContentList;
        private List<? extends Jump> jumpList;

        private EmphasisContent emphasisContent;
        private String subTitleText;

        protected Builder(String taskId, CardAction cardAction) {
            this.taskId = taskId;
            this.cardAction = cardAction;
        }

        public Builder mainTitle(MainTitle mainTitle) {
            this.mainTitle = mainTitle;
            return this;
        }

        public Builder source(CardSource source) {
            this.source = source;
            return this;
        }

        public Builder actionMenu(ActionMenu actionMenu) {
            this.actionMenu = actionMenu;
            return this;
        }

        public Builder quoteArea(QuoteArea quoteArea) {
            this.quoteArea = quoteArea;
            return this;
        }

        public Builder horizontalContentList(List<? extends HorizontalContent> horizontalContentList) {
            this.horizontalContentList = horizontalContentList;
            return this;
        }

        public Builder jumpList(List<? extends Jump> jumpList) {
            this.jumpList = jumpList;
            return this;
        }


        public Builder emphasisContent(EmphasisContent emphasisContent) {
            this.emphasisContent = emphasisContent;
            return this;
        }

        public Builder subTitleText(String subTitleText) {
            this.subTitleText = subTitleText;
            return this;
        }

        public TextMessageTemplateCard build() {
            return new TextMessageTemplateCard(taskId, mainTitle, source,
                    actionMenu, quoteArea,
                    horizontalContentList, jumpList,
                    cardAction, emphasisContent, subTitleText);
        }
    }

}
