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

package cn.felord.domain.callcenter.knowledge;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * The type Intent.
 *
 * @author dax
 * @since 2023 /10/5
 */
@ToString
@Getter
@RequiredArgsConstructor
public class UpdateIntentRequest {
    private final String intentId;
    private TextQuestion question;
    private List<Answer> answers;
    private SimilarQuestions similarQuestions;

    public UpdateIntentRequest question(String content) {
        this.question = TextQuestion.from(content);
        return this;
    }

    public UpdateIntentRequest answers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }

    public UpdateIntentRequest similarQuestions(List<String> similarQuestionContents) {
        this.similarQuestions = SimilarQuestions.from(similarQuestionContents);
        return this;
    }
}