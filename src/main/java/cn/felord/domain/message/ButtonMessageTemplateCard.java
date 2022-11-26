package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardAction;
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.EmphasisContent;
import cn.felord.domain.webhook.card.HorizontalContent;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.QuoteArea;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/23 12:19
 */
@Getter
public class ButtonMessageTemplateCard extends MessageTemplateCard {
    private final String subTitleText;
    private final List<EmphasisContent> verticalContentList;
    private final ButtonSelection buttonSelection;
    private final List<Button> buttonList;

    protected ButtonMessageTemplateCard(String taskId, MainTitle mainTitle, CardSource source,
                                        ActionMenu actionMenu, QuoteArea quoteArea, List<? extends HorizontalContent> horizontalContentList,
                                        CardAction cardAction, String subTitleText, List<EmphasisContent> verticalContentList,
                                        ButtonSelection buttonSelection, List<Button> buttonList) {
        super(TemplateCardType.BUTTON_INTERACTION, taskId, mainTitle, source, actionMenu, quoteArea, horizontalContentList, null, cardAction);
        this.subTitleText = subTitleText;
        this.verticalContentList = verticalContentList;
        this.buttonSelection = buttonSelection;
        this.buttonList = buttonList;
    }

    public static class Builder {
        private final String taskId;
        private final List<Button> buttonList;
        private final MainTitle mainTitle;
        private CardAction cardAction;
        private CardSource source;
        private ActionMenu actionMenu;
        private QuoteArea quoteArea;
        private List<? extends HorizontalContent> horizontalContentList;
        private String subTitleText;
        private List<EmphasisContent> verticalContentList;
        private ButtonSelection buttonSelection;

        protected Builder(String taskId, MainTitle mainTitle, List<Button> buttonList) {
            this.taskId = taskId;
            this.mainTitle = mainTitle;
            this.buttonList = buttonList;
        }

        public Builder source(CardSource source) {
            this.source = source;
            return this;
        }

        public Builder actionMenu(ActionMenu actionMenu) {
            this.actionMenu = actionMenu;
            return this;
        }

        public Builder cardAction(CardAction cardAction) {
            this.cardAction = cardAction;
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

        public Builder subTitleText(String subTitleText) {
            this.subTitleText = subTitleText;
            return this;
        }

        public Builder verticalContentList(List<EmphasisContent> verticalContentList) {
            this.verticalContentList = verticalContentList;
            return this;
        }

        public Builder buttonSelection(ButtonSelection buttonSelection) {
            this.buttonSelection = buttonSelection;
            return this;
        }

        public ButtonMessageTemplateCard build() {
            return new ButtonMessageTemplateCard(taskId, mainTitle, source,
                    actionMenu, quoteArea, horizontalContentList,
                    cardAction, subTitleText, verticalContentList,
                    buttonSelection, buttonList);
        }
    }

}
