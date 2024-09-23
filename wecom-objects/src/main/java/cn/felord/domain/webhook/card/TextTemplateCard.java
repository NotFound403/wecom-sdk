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

package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 文本通知模版卡片
 *
 * @author felord.cn
 * @since 2021 /9/3 15:56
 */
@ToString
@Getter
public class TextTemplateCard extends TemplateCard {
    private EmphasisContent emphasisContent;
    private String subTitleText;

    /**
     * Instantiates a new Text template card.
     *
     * @param mainTitle  the main title
     * @param cardAction the card action
     */
    public TextTemplateCard(MainTitle mainTitle, CardAction cardAction) {
        super(CardType.TEXT_NOTICE, mainTitle, cardAction);
    }

    /**
     * Emphasis content text template card.
     *
     * @param emphasisContent the emphasis content
     * @return the text template card
     */
    public TextTemplateCard emphasisContent(EmphasisContent emphasisContent) {
        this.emphasisContent = emphasisContent;
        return this;
    }

    /**
     * Sub title text text template card.
     *
     * @param subTitleText the sub title text
     * @return the text template card
     */
    public TextTemplateCard subTitleText(String subTitleText) {
        this.subTitleText = subTitleText;
        return this;
    }

    @Override
    public TextTemplateCard source(CardSource source) {
        super.source(source);
        return this;
    }

    @Override
    public TextTemplateCard quoteArea(QuoteArea quoteArea) {
        super.quoteArea(quoteArea);
        return this;
    }

    @Override
    public TextTemplateCard horizontalContentList(List<? extends HorizontalContent> horizontalContentList) {
        super.horizontalContentList(horizontalContentList);
        return this;
    }

    @Override
    public TextTemplateCard jumpList(List<? extends Jump> jumpList) {
        super.jumpList(jumpList);
        return this;
    }
}
