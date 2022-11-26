package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardAction;
import cn.felord.domain.webhook.card.MainTitle;

import java.util.List;

/**
 * The type Template card builders.
 *
 * @author dax
 * @since 2022 /11/26
 */
public final class TemplateCardBuilders {

    private TemplateCardBuilders() {
    }

    /**
     * 文本通知型
     *
     * @param taskId     the task id
     * @param cardAction the card action
     * @return the text message template card . builder
     */
    public static TextMessageTemplateCard.Builder textMessageTemplateCardBuilder(String taskId, CardAction cardAction) {
        return new TextMessageTemplateCard.Builder(taskId, cardAction);
    }

    /**
     * 图文展示型
     *
     * @param taskId     the task id
     * @param mainTitle  the main title
     * @param cardAction the card action
     * @return the news message template card . builder
     */
    public static NewsMessageTemplateCard.Builder newsMessageTemplateCardBuilder(String taskId, MainTitle mainTitle, CardAction cardAction) {
        return new NewsMessageTemplateCard.Builder(taskId, mainTitle, cardAction);
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
