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
 * The type Template card.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:47
 */
@ToString
@Getter
public abstract class TemplateCard {
    private final CardType cardType;
    private CardSource source;
    private final MainTitle mainTitle;
    private  QuoteArea quoteArea;
    private List<? extends HorizontalContent> horizontalContentList;
    private List<? extends Jump> jumpList;
    private final CardAction cardAction;


    /**
     * Instantiates a new Template card.
     *
     * @param cardType   the card type
     * @param mainTitle  the main title
     * @param cardAction the card action
     */
    protected TemplateCard(CardType cardType, MainTitle mainTitle, CardAction cardAction) {
        this.cardType = cardType;
        this.mainTitle = mainTitle;
        this.cardAction = cardAction;
    }

    /**
     * Source template card.
     *
     * @param source the source
     * @return the template card
     */
    protected TemplateCard source(CardSource source) {
        this.source = source;
        return this;
    }

    /**
     * Quote area template card.
     *
     * @param quoteArea the quote area
     * @return the template card
     */
    protected TemplateCard quoteArea(QuoteArea quoteArea) {
        this.quoteArea = quoteArea;
        return this;
    }

    /**
     * Horizontal content list template card.
     *
     * @param horizontalContentList the horizontal content list
     * @return the template card
     */
    protected TemplateCard horizontalContentList(List<? extends HorizontalContent> horizontalContentList) {
        this.horizontalContentList = horizontalContentList;
        return this;
    }

    /**
     * Jump list template card.
     *
     * @param jumpList the jump list
     * @return the template card
     */
    protected TemplateCard jumpList(List<? extends Jump> jumpList) {
        this.jumpList = jumpList;
        return this;
    }
}
