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
import cn.felord.domain.webhook.card.MainTitle;

import java.util.List;

/**
 * The type Template card builders.
 *
 * @author dax
 * @since 2021 /11/26
 */
public final class TemplateReplaceCardBuilders {

    private TemplateReplaceCardBuilders() {
    }

    /**
     * 文本通知型
     *
     * @param cardAction the card action
     * @return the text message template card . builder
     */
    public static TextMessageTemplateReplaceCard.Builder textMessageTemplateReplaceCardBuilder(CardAction cardAction) {
        return new TextMessageTemplateReplaceCard.Builder(cardAction);
    }

    /**
     * 图文展示型
     *
     * @param mainTitle  the main title
     * @param cardAction the card action
     * @return the news message template card . builder
     */
    public static NewsMessageTemplateReplaceCard.Builder newsMessageTemplateReplaceCardBuilder(MainTitle mainTitle, CardAction cardAction) {
        return new NewsMessageTemplateReplaceCard.Builder(mainTitle, cardAction);
    }

    /**
     * 按钮交互型
     *
     * @param mainTitle  the main title
     * @param buttonList the button list
     * @return the button message template card . builder
     */
    public static ButtonMessageTemplateReplaceCard.Builder buttonMessageTemplateReplaceCardBuilder(MainTitle mainTitle, List<Button> buttonList) {
        return new ButtonMessageTemplateReplaceCard.Builder(mainTitle, buttonList);
    }

    /**
     * 投票选择型
     *
     * @param mainTitle the main title
     * @return the vote message template card . builder
     */
    public static VoteMessageTemplateReplaceCard.Builder voteMessageTemplateReplaceCardBuilder(MainTitle mainTitle) {
        return new VoteMessageTemplateReplaceCard.Builder(mainTitle);
    }

    /**
     * 多项选择型
     *
     * @param mainTitle    the main title
     * @param selectList   the select list
     * @param submitButton the submit button
     * @return the multiple message template card . builder
     */
    public static MultipleMessageTemplateReplaceCard.Builder multipleMessageTemplateReplaceCardBuilder(MainTitle mainTitle, List<Select> selectList, SubmitButton submitButton) {
        return new MultipleMessageTemplateReplaceCard.Builder(mainTitle, selectList, submitButton);
    }
}
