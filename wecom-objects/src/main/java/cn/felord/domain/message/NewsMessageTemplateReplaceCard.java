/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardAction;
import cn.felord.domain.webhook.card.CardImage;
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.EmphasisContent;
import cn.felord.domain.webhook.card.HorizontalContent;
import cn.felord.domain.webhook.card.ImageTextArea;
import cn.felord.domain.webhook.card.Jump;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.QuoteArea;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author felord
 * @since 2021/11/23 12:19
 */
@ToString
@Getter
public class NewsMessageTemplateReplaceCard extends MessageTemplateReplaceCard {
    private final ImageTextArea imageTextArea;
    private final CardImage cardImage;
    private final List<EmphasisContent> verticalContentList;

    public NewsMessageTemplateReplaceCard(MainTitle mainTitle,
                                          CardSource source, ActionMenu actionMenu, QuoteArea quoteArea,
                                          List<? extends HorizontalContent> horizontalContentList, List<? extends Jump> jumpList, CardAction cardAction,
                                          ImageTextArea imageTextArea, CardImage cardImage, List<EmphasisContent> verticalContentList) {
        super(TemplateCardType.NEWS_NOTICE, mainTitle, source, actionMenu, quoteArea, horizontalContentList, jumpList, cardAction);
        this.imageTextArea = imageTextArea;
        this.cardImage = cardImage;
        this.verticalContentList = verticalContentList;
    }

    public static class Builder {
        private final CardAction cardAction;
        private final MainTitle mainTitle;
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


        public NewsMessageTemplateReplaceCard build() {
            return new NewsMessageTemplateReplaceCard(mainTitle, source,
                    actionMenu, quoteArea,
                    horizontalContentList, jumpList,
                    cardAction, imageTextArea, cardImage, verticalContentList);
        }
    }

}
