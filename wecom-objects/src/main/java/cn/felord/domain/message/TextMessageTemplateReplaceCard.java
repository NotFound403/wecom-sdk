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
import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.EmphasisContent;
import cn.felord.domain.webhook.card.HorizontalContent;
import cn.felord.domain.webhook.card.Jump;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.domain.webhook.card.QuoteArea;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Text message template card.
 *
 * @author felord
 * @since 2021 /11/23 11:35
 */
@ToString
@Getter
public class TextMessageTemplateReplaceCard extends MessageTemplateReplaceCard {
    private final EmphasisContent emphasisContent;
    private final String subTitleText;


    protected TextMessageTemplateReplaceCard(MainTitle mainTitle, CardSource source,
                                             ActionMenu actionMenu, QuoteArea quoteArea,
                                             List<? extends HorizontalContent> horizontalContentList, List<? extends Jump> jumpList,
                                             CardAction cardAction, EmphasisContent emphasisContent, String subTitleText) {
        super(TemplateCardType.TEXT_NOTICE, mainTitle, source, actionMenu, quoteArea, horizontalContentList, jumpList, cardAction);
        this.emphasisContent = emphasisContent;
        this.subTitleText = subTitleText;
    }

    public static class Builder {
        private final CardAction cardAction;
        private MainTitle mainTitle;
        private CardSource source;
        private ActionMenu actionMenu;
        private QuoteArea quoteArea;
        private List<? extends HorizontalContent> horizontalContentList;
        private List<? extends Jump> jumpList;

        private EmphasisContent emphasisContent;
        private String subTitleText;

        protected Builder(CardAction cardAction) {
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

        public TextMessageTemplateReplaceCard build() {
            return new TextMessageTemplateReplaceCard(mainTitle, source,
                    actionMenu, quoteArea,
                    horizontalContentList, jumpList,
                    cardAction, emphasisContent, subTitleText);
        }
    }

}
