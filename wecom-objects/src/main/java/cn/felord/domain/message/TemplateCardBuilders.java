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
public final class TemplateCardBuilders {

    private TemplateCardBuilders() {
    }

    /**
     * 文本通知型
     *
     * @param cardAction the card action
     * @return the text message template card . builder
     */
    public static TextMessageTemplateCard.Builder textMessageTemplateCardBuilder(CardAction cardAction) {
        return new TextMessageTemplateCard.Builder(cardAction);
    }

    /**
     * 图文展示型
     *
     * @param mainTitle  the main title
     * @param cardAction the card action
     * @return the news message template card . builder
     */
    public static NewsMessageTemplateCard.Builder newsMessageTemplateCardBuilder(MainTitle mainTitle, CardAction cardAction) {
        return new NewsMessageTemplateCard.Builder(mainTitle, cardAction);
    }

    /**
     * 按钮交互型
     *
     * @param taskId     the task id
     * @param mainTitle  the main title
     * @param buttonList the button list
     * @return the button message template card . builder
     */
    public static ButtonMessageTemplateCard.Builder buttonMessageTemplateCardBuilder(String taskId, MainTitle mainTitle, List<Button> buttonList) {
        return new ButtonMessageTemplateCard.Builder(taskId, mainTitle, buttonList);
    }

    /**
     * 投票选择型
     *
     * @param taskId    the task id
     * @param mainTitle the main title
     * @return the vote message template card . builder
     */
    public static VoteMessageTemplateCard.Builder voteMessageTemplateCardBuilder(String taskId, MainTitle mainTitle) {
        return new VoteMessageTemplateCard.Builder(taskId, mainTitle);
    }

    /**
     * 多项选择型
     *
     * @param taskId       the task id
     * @param mainTitle    the main title
     * @param selectList   the select list
     * @param submitButton the submit button
     * @return the multiple message template card . builder
     */
    public static MultipleMessageTemplateCard.Builder multipleMessageTemplateCardBuilder(String taskId, MainTitle mainTitle, List<Select> selectList, SubmitButton submitButton) {
        return new MultipleMessageTemplateCard.Builder(taskId, mainTitle, selectList, submitButton);
    }
}
