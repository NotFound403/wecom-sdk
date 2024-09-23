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
import java.util.stream.Collectors;

/**
 * The type Similar questions.
 *
 * @author dax
 * @since 2024/10/5
 */
@ToString
@Getter
public class SimilarQuestions {
    private final List<TextQuestion> items;

    /**
     * Instantiates a new Similar questions.
     *
     * @param items the items
     */
    @JsonCreator
    SimilarQuestions(@JsonProperty("items") List<TextQuestion> items) {
        this.items = items;
    }

    /**
     * From similar questions.
     *
     * @param contents the contents
     * @return the similar questions
     */
    public static SimilarQuestions from(List<String> contents) {
        return new SimilarQuestions(contents.stream()
                .map(TextQuestion::from)
                .collect(Collectors.toList()));
    }

}
