package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:56
 */
@Setter
@Getter
public class TextTemplateCard extends TemplateCard {
    private EmphasisContent emphasisContent;
    private String subTitleText;

    public TextTemplateCard(MainTitle mainTitle, CardAction cardAction) {
        super(CardType.TEXT_NOTICE, mainTitle, cardAction);
    }
}
