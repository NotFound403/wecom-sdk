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

package cn.felord.domain.callcenter.knowledge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Intent detail.
 *
 * @author dax
 * @since 2024/10/5
 */
@ToString
@Getter
public class IntentDetail {
    private final String groupId;
    private final String intentId;
    private final TextQuestion question;
    private final List<IntentAnswer> answers;
    private final SimilarQuestions similarQuestions;

    /**
     * Instantiates a new Intent.
     *
     * @param groupId          the group id
     * @param intentId         the intent id
     * @param question         the question
     * @param answers          the answers
     * @param similarQuestions the similar questions
     */
    @JsonCreator
    IntentDetail(@JsonProperty("group_id") String groupId,
                 @JsonProperty("intent_id") String intentId,
                 @JsonProperty("question") TextQuestion question,
                 @JsonProperty("answers") List<IntentAnswer> answers,
                 @JsonProperty("similar_questions") SimilarQuestions similarQuestions) {
        this.groupId = groupId;
        this.intentId = intentId;
        this.question = question;
        this.similarQuestions = similarQuestions;
        this.answers = answers;
    }
}
