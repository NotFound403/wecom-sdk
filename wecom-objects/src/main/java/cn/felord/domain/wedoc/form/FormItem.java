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
 * @see SettingFormItem
 * @since 2024/3/13 16:34
 */
@Deprecated
@ToString
@Getter
public class FormItem {
    private final int questionId;
    private final String title;
    private final int pos;
    private final FormItemStatus status;
    private final FormItemReplyType replyType;
    private final boolean mustReply;
    private final String note;
    private final String placeholder;
    private final List<FormOptionItem> optionItem;


    /**
     * Instantiates a new Form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param replyType  the reply type
     * @param mustReply  the must reply
     * @param optionItem the option item
     */
    public FormItem(int questionId,
                    String title,
                    int pos,
                    FormItemStatus status,
                    FormItemReplyType replyType,
                    boolean mustReply,
                    List<FormOptionItem> optionItem) {
        this(questionId, title, pos, status, replyType, mustReply, null, null, optionItem);
    }

    /**
     * Instantiates a new Form item.
     *
     * @param questionId  the question id
     * @param title       the title
     * @param pos         the pos
     * @param status      the status
     * @param replyType   the reply type
     * @param mustReply   the must reply
     * @param note        the note
     * @param placeholder the placeholder
     * @param optionItem  the option item
     */
    @JsonCreator
    public FormItem(@JsonProperty("question_id") int questionId,
                    @JsonProperty("title") String title,
                    @JsonProperty("pos") int pos,
                    @JsonProperty("status") FormItemStatus status,
                    @JsonProperty("reply_type") FormItemReplyType replyType,
                    @JsonProperty("must_reply") boolean mustReply,
                    @JsonProperty("note") String note,
                    @JsonProperty("placeholder") String placeholder,
                    @JsonProperty("option_item") List<FormOptionItem> optionItem) {
        this.questionId = questionId;
        this.title = title;
        this.pos = pos;
        this.status = status;
        this.replyType = replyType;
        this.mustReply = mustReply;
        this.note = note;
        this.placeholder = placeholder;
        this.optionItem = optionItem;
    }
}
