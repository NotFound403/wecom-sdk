package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author felord.cn
 * @since 2021/9/3 16:46
 */
@Setter
@Getter
public class NewsTemplateCard extends TemplateCard {
    private final CardImage cardImage;
    private ImageTextArea imageTextArea;
    private List<EmphasisContent> verticalContentList;

    public NewsTemplateCard(MainTitle mainTitle, CardImage cardImage,CardAction cardAction) {
        super(CardType.NEWS_NOTICE, mainTitle, cardAction);
        this.cardImage = cardImage;
    }
}
