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

import cn.felord.enumeration.FormItemReplyType;
import cn.felord.enumeration.FormItemStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Form item.
 *
 * @author dax
 * @since 2023 /3/13 16:34
 */
@ToString
@Getter
public class SettingFormItem {
    private final int questionId;
    private final String title;
    private final int pos;
    private final FormItemStatus status;
    private final FormItemReplyType replyType;
    private final boolean mustReply;
    private final String note;
    private final String placeholder;
    private final List<FormOptionItem> optionItem;
    private final QuestionExtendSetting questionExtendSetting;

    /**
     * Instantiates a new Form item.
     *
     * @param questionId            the question id
     * @param title                 the title
     * @param pos                   the pos
     * @param status                the status
     * @param replyType             the reply type
     * @param mustReply             the must reply
     * @param note                  the note
     * @param placeholder           the placeholder
     * @param optionItem            the option item
     * @param questionExtendSetting the question extend setting
     */
    @JsonCreator
    public SettingFormItem(@JsonProperty("question_id") int questionId,
                           @JsonProperty("title") String title,
                           @JsonProperty("pos") int pos,
                           @JsonProperty("status") FormItemStatus status,
                           @JsonProperty("reply_type") FormItemReplyType replyType,
                           @JsonProperty("must_reply") boolean mustReply,
                           @JsonProperty("note") String note,
                           @JsonProperty("placeholder") String placeholder,
                           @JsonProperty("option_item") List<FormOptionItem> optionItem,
                           @JsonProperty("question_extend_setting") QuestionExtendSetting questionExtendSetting) {
        this.questionId = questionId;
        this.title = title;
        this.pos = pos;
        this.status = status;
        this.replyType = replyType;
        this.mustReply = mustReply;
        this.note = note;
        this.placeholder = placeholder;
        this.optionItem = optionItem;
        this.questionExtendSetting = questionExtendSetting;
    }


    /**
     * Text setting form item.
     *
     * @param questionId            the question id
     * @param title                 the title
     * @param pos                   the pos
     * @param status                the status
     * @param mustReply             the must reply
     * @param note                  the note
     * @param placeholder           the placeholder
     * @param questionExtendSetting the question extend setting
     * @return the setting form item
     */
    public static SettingFormItem text(int questionId,
                                       String title,
                                       int pos,
                                       FormItemStatus status,
                                       boolean mustReply,
                                       String note,
                                       String placeholder,
                                       TextQuestionExtendSetting questionExtendSetting) {
        return new SettingFormItem(questionId,
                title,
                pos,
                status,
                FormItemReplyType.TEXT,
                mustReply,
                note,
                placeholder,
                null,
                questionExtendSetting);
    }


}
