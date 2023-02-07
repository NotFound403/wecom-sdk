package cn.felord.domain.message;

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/23 12:19
 */
@Getter
public class VoteMessageTemplateReplaceCard extends AbstractReplaceCard {
    private final Checkbox checkbox;
    private final SubmitButton submitButton;

    protected VoteMessageTemplateReplaceCard(MainTitle mainTitle, CardSource source, Checkbox checkbox, SubmitButton submitButton) {
        super(TemplateCardType.VOTE_INTERACTION, mainTitle, source);
        this.checkbox = checkbox;
        this.submitButton = submitButton;
    }

    public static class Builder {
        private final MainTitle mainTitle;
        private Checkbox checkbox;
        private SubmitButton submitButton;
        private CardSource source;

        protected Builder(MainTitle mainTitle) {
            this.mainTitle = mainTitle;
        }

        public Builder source(CardSource source) {
            this.source = source;
            return this;
        }

        public Builder checkbox(Checkbox checkbox) {
            this.checkbox = checkbox;
            return this;
        }

        public Builder submitButton(SubmitButton submitButton) {
            this.submitButton = submitButton;
            return this;
        }

        public VoteMessageTemplateReplaceCard build() {
            return new VoteMessageTemplateReplaceCard(mainTitle, source, checkbox, submitButton);
        }
    }
}