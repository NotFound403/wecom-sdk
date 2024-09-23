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

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Abstract card.
 *
 * @author dax
 * @see TemplateCardBuilders
 * @since 2021 /11/24
 */
@ToString
@Getter
public abstract class AbstractCard {
    private final TemplateCardType cardType;
    private final String taskId;
    private final MainTitle mainTitle;
    private final CardSource source;


    /**
     * Instantiates a new Abstract card.
     *
     * @param cardType  the card type
     * @param taskId    the task id
     * @param mainTitle the main title
     * @param source    the source
     */
    public AbstractCard(TemplateCardType cardType, String taskId, MainTitle mainTitle, CardSource source) {
        this.cardType = cardType;
        this.taskId = taskId;
        this.mainTitle = mainTitle;
        this.source = source;
    }

}
