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
 * 图文展示模版卡片
 *
 * @author felord.cn
 * @since 2021 /9/3 16:46
 */
@ToString
@Getter
public class NewsTemplateCard extends TemplateCard {
    private final CardImage cardImage;
    private ImageTextArea imageTextArea;
    private List<EmphasisContent> verticalContentList;

    /**
     * Instantiates a new News template card.
     *
     * @param mainTitle  the main title
     * @param cardImage  the card image
     * @param cardAction the card action
     */
    public NewsTemplateCard(MainTitle mainTitle, CardImage cardImage, CardAction cardAction) {
        super(CardType.NEWS_NOTICE, mainTitle, cardAction);
        this.cardImage = cardImage;
    }

    /**
     * Image text area news template card.
     *
     * @param imageTextArea the image text area
     * @return the news template card
     */
    public NewsTemplateCard imageTextArea(ImageTextArea imageTextArea) {
        this.imageTextArea = imageTextArea;
        return this;
    }

    /**
     * Vertical content list news template card.
     *
     * @param verticalContentList the vertical content list
     * @return the news template card
     */
    public NewsTemplateCard verticalContentList(List<EmphasisContent> verticalContentList) {
        this.verticalContentList = verticalContentList;
        return this;
    }

    @Override
    public NewsTemplateCard source(CardSource source) {
        super.source(source);
        return this;
    }

    @Override
    public NewsTemplateCard quoteArea(QuoteArea quoteArea) {
        super.quoteArea(quoteArea);
        return this;
    }

    @Override
    public NewsTemplateCard horizontalContentList(List<? extends HorizontalContent> horizontalContentList) {
        super.horizontalContentList(horizontalContentList);
        return this;
    }

    @Override
    public NewsTemplateCard jumpList(List<? extends Jump> jumpList) {
        super.jumpList(jumpList);
        return this;
    }
}
