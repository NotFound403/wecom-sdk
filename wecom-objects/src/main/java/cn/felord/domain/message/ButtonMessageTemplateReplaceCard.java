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
public class ButtonMessageTemplateReplaceCard extends MessageTemplateReplaceCard {
    private final String subTitleText;
    private final List<EmphasisContent> verticalContentList;
    private final ButtonSelection buttonSelection;
    private final List<Button> buttonList;

    protected ButtonMessageTemplateReplaceCard(MainTitle mainTitle, CardSource source,
                                               ActionMenu actionMenu, QuoteArea quoteArea, List<? extends HorizontalContent> horizontalContentList,
                                               CardAction cardAction, String subTitleText, List<EmphasisContent> verticalContentList,
                                               ButtonSelection buttonSelection, List<Button> buttonList) {
        super(TemplateCardType.BUTTON_INTERACTION, mainTitle, source, actionMenu, quoteArea, horizontalContentList, null, cardAction);
        this.subTitleText = subTitleText;
        this.verticalContentList = verticalContentList;
        this.buttonSelection = buttonSelection;
        this.buttonList = buttonList;
    }

    public static class Builder {

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

        protected Builder(MainTitle mainTitle, List<Button> buttonList) {
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

        public ButtonMessageTemplateReplaceCard build() {
            return new ButtonMessageTemplateReplaceCard(mainTitle, source,
                    actionMenu, quoteArea, horizontalContentList,
                    cardAction, subTitleText, verticalContentList,
                    buttonSelection, buttonList);
        }
    }

}
