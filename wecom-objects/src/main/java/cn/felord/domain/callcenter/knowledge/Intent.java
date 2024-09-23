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
 * The type Intent.
 *
 * @author dax
 * @since 2024/10/5
 */
@ToString
@Getter
public class Intent {
    private final String groupId;
    private final TextQuestion question;
    private final List<Answer> answers;
    private final SimilarQuestions similarQuestions;

    /**
     * Instantiates a new Intent.
     *
     * @param groupId the group id
     * @param content the content
     * @param answers the answers
     */
    public Intent(String groupId, String content, List<Answer> answers) {
        this(groupId, content, answers, null);
    }

    public Intent(String groupId, String content, List<Answer> answers, List<String> similarQuestionContents) {
        this(groupId, TextQuestion.from(content), answers, SimilarQuestions.from(similarQuestionContents));
    }

    /**
     * Instantiates a new Intent.
     *
     * @param groupId          the group id
     * @param question         the question
     * @param answers          the answers
     * @param similarQuestions the similar questions
     */
    @JsonCreator
    Intent(@JsonProperty("group_id") String groupId,
           @JsonProperty("question") TextQuestion question,
           @JsonProperty("answers") List<Answer> answers,
           @JsonProperty("similar_questions") SimilarQuestions similarQuestions) {
        this.groupId = groupId;
        this.question = question;
        this.similarQuestions = similarQuestions;
        this.answers = answers;
    }
}
