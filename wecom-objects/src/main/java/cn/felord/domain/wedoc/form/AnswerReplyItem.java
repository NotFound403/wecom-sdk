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

package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.AnswerReplyItemType;
import cn.felord.utils.CollectionUtils;
import cn.felord.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author dax
 * @since 2023/3/16 15:42
 */
@ToString
@Getter
public class AnswerReplyItem {
    private final AnswerReplyItemType itemType;
    private final Integer questionId;
    private final String textReply;
    private final List<Integer> optionReply;
    private final List<AnswerOptionExtendReply> optionExtendReply;
    private final List<AnswerFileExtendReply> fileExtendReply;


    @JsonCreator
    public AnswerReplyItem(@JsonProperty("question_id") Integer questionId,
                           @JsonProperty("text_reply") String textReply,
                           @JsonProperty("option_reply") List<Integer> optionReply,
                           @JsonProperty("option_extend_reply") List<AnswerOptionExtendReply> optionExtendReply,
                           @JsonProperty("file_extend_reply") List<AnswerFileExtendReply> fileExtendReply) {
        this.itemType = StringUtils.hasText(textReply) ? AnswerReplyItemType.TEXT :
                !CollectionUtils.isEmpty(optionReply) ? AnswerReplyItemType.OPTION :
                        !CollectionUtils.isEmpty(fileExtendReply) ? AnswerReplyItemType.FILE : AnswerReplyItemType.INVALID;
        this.questionId = questionId;
        this.textReply = textReply;
        this.optionReply = optionReply;
        this.optionExtendReply = optionExtendReply;
        this.fileExtendReply = fileExtendReply;
    }
}
