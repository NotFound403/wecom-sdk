package cn.felord.domain.message;

import cn.felord.domain.webhook.card.EmphasisContent;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Builder;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/23 12:19
 */
@Builder
public class VoteMessageTemplateCard extends MessageTemplateCard {
    private String subTitleText;
    private List<EmphasisContent> verticalContentList;
    private ButtonSelection buttonSelection;
    private final List<Button> buttonList;

    public VoteMessageTemplateCard(String taskId, MainTitle mainTitle, List<Button> buttonList) {
        super(TemplateCardType.VOTE_INTERACTION, taskId, mainTitle);
        this.buttonList = buttonList;
    }
}
