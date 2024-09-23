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

import cn.felord.domain.webhook.card.CardSource;
import cn.felord.domain.webhook.card.MainTitle;
import cn.felord.enumeration.TemplateCardType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Multiple message template card.
 *
 * @author felord
 * @since 2021 /11/23 12:19
 */
@ToString
@Getter
public class MultipleMessageTemplateCard extends AbstractCard {
    private final List<Select> selectList;
    private final SubmitButton submitButton;

    protected MultipleMessageTemplateCard(String taskId, MainTitle mainTitle, CardSource source, List<Select> selectList, SubmitButton submitButton) {
        super(TemplateCardType.MULTIPLE_INTERACTION, taskId, mainTitle, source);
        this.selectList = selectList;
        this.submitButton = submitButton;
    }

    public static class Builder {
        private final String taskId;

        private final MainTitle mainTitle;
        private final List<Select> selectList;
        private final SubmitButton submitButton;
        private CardSource source;

        protected Builder(String taskId, MainTitle mainTitle, List<Select> selectList, SubmitButton submitButton) {
            this.taskId = taskId;
            this.mainTitle = mainTitle;
            this.selectList = selectList;
            this.submitButton = submitButton;
        }

        public Builder source(CardSource source) {
            this.source = source;
            return this;
        }

        public MultipleMessageTemplateCard build() {
            return new MultipleMessageTemplateCard(taskId, mainTitle, source, selectList, submitButton);
        }
    }
}
