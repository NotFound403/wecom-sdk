package cn.felord.domain.message;

import cn.felord.domain.webhook.card.*;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

import java.util.List;

/**
 * @author felord
 * @since 2021/11/23 12:19
 */
@Getter
public class NewsMessageTemplateCard extends MessageTemplateCard {
    private final ImageTextArea imageTextArea;
    private final CardImage cardImage;
    private final List<EmphasisContent> verticalContentList;

    public NewsMessageTemplateCard(String taskId, MainTitle mainTitle,
                                   CardSource source, ActionMenu actionMenu, QuoteArea quoteArea,
                                   List<? extends HorizontalContent> horizontalContentList, List<? extends Jump> jumpList, CardAction cardAction,
                                   ImageTextArea imageTextArea, CardImage cardImage, List<EmphasisContent> verticalContentList) {
        super(TemplateCardType.NEWS_NOTICE, taskId, mainTitle, source, actionMenu, quoteArea, horizontalContentList, jumpList, cardAction);
        this.imageTextArea = imageTextArea;
        this.cardImage = cardImage;
        this.verticalContentList = verticalContentList;
    }

    public static class Builder {
        private final CardAction cardAction;
        private final MainTitle mainTitle;
        private String taskId;
        private CardSource source;
        private ActionMenu actionMenu;
        private QuoteArea quoteArea;
        private List<? extends HorizontalContent> horizontalContentList;
        private List<? extends Jump> jumpList;
        private ImageTextArea imageTextArea;
        private CardImage cardImage;
        private List<EmphasisContent> verticalContentList;

        protected Builder(MainTitle mainTitle, CardAction cardAction) {
            this.mainTitle = mainTitle;
            this.cardAction = cardAction;
        }

        public Builder source(CardSource source) {
            this.source = source;
            return this;
        }

        public Builder actionMenu(String taskId, ActionMenu actionMenu) {
            this.taskId = taskId;
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

        public Builder imageTextArea(ImageTextArea imageTextArea) {
            this.imageTextArea = imageTextArea;
            return this;
        }

        public Builder cardImage(CardImage cardImage) {
            this.cardImage = cardImage;
            return this;
        }

        public Builder verticalContentList(List<EmphasisContent> verticalContentList) {
            this.verticalContentList = verticalContentList;
            return this;
        }


        public NewsMessageTemplateCard build() {
            return new NewsMessageTemplateCard(taskId, mainTitle, source,
                    actionMenu, quoteArea,
                    horizontalContentList, jumpList,
                    cardAction, imageTextArea, cardImage, verticalContentList);
        }
    }

}
