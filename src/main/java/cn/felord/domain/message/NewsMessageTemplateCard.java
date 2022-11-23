package cn.felord.domain.message;

import cn.felord.domain.webhook.card.*;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/23 12:19
 */
@Getter
public class NewsMessageTemplateCard extends MessageTemplateCard {
    private ImageTextArea imageTextArea;
    private CardImage cardImage;
    private List<EmphasisContent> verticalContentList;

    public NewsMessageTemplateCard(String taskId, MainTitle mainTitle, CardAction cardAction) {
        super(TemplateCardType.NEWS_NOTICE, taskId, mainTitle, cardAction);
    }
}
