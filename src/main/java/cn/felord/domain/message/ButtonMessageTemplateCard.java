package cn.felord.domain.message;

import cn.felord.domain.webhook.card.*;
import cn.felord.enumeration.TemplateCardType;
import lombok.Builder;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/23 12:19
 */
@Builder
public class ButtonMessageTemplateCard extends MessageTemplateCard {
    private String subTitleText;
    private List<EmphasisContent> verticalContentList;
    private ButtonSelection buttonSelection;
    private final List<Button> buttonList;

    public ButtonMessageTemplateCard(String taskId, MainTitle mainTitle, List<Button> buttonList) {
        super(TemplateCardType.BUTTON_INTERACTION, taskId, mainTitle);
        this.buttonList = buttonList;
    }
}
