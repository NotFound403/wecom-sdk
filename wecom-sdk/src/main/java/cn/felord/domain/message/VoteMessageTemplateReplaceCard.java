/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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