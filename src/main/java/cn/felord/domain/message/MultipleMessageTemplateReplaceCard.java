package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

import java.util.List;

/**
 * The type Multiple message template card.
 *
 * @author felord
 * @since 2021 /11/23 12:19
 */
@Getter
public class MultipleMessageTemplateReplaceCard extends AbstractReplaceCard {
    private final List<Select> selectList;
    private final SubmitButton submitButton;

    protected MultipleMessageTemplateReplaceCard(MainTitle mainTitle, CardSource source, List<Select> selectList, SubmitButton submitButton) {
        super(TemplateCardType.MULTIPLE_INTERACTION, mainTitle, source);
        this.selectList = selectList;
        this.submitButton = submitButton;
    }

    public static class Builder {
        private final MainTitle mainTitle;
        private final List<Select> selectList;
        private final SubmitButton submitButton;
        private CardSource source;

        protected Builder(MainTitle mainTitle, List<Select> selectList, SubmitButton submitButton) {
            this.mainTitle = mainTitle;
            this.selectList = selectList;
            this.submitButton = submitButton;
        }

        public Builder source(CardSource source) {
            this.source = source;
            return this;
        }

        public MultipleMessageTemplateReplaceCard build() {
            return new MultipleMessageTemplateReplaceCard(mainTitle, source, selectList, submitButton);
        }
    }
}
