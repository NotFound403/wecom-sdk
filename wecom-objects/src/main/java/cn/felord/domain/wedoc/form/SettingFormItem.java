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
 * @param <Q> the type parameter
 * @author dax
 * @since 2023 /3/13 16:34
 */
@ToString
@Getter
public class SettingFormItem<Q extends QuestionExtendSetting> {
    private final int questionId;
    private final String title;
    private final int pos;
    private final FormItemStatus status;
    private final FormItemReplyType replyType;
    private final boolean mustReply;
    private final List<FormOptionItem> optionItem;
    private String note;
    private String placeholder;
    private Q questionExtendSetting;

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
    public SettingFormItem(@JsonProperty("question_id") int questionId,
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

    /**
     * Instantiates a new Setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param replyType  the reply type
     * @param mustReply  the must reply
     * @param optionItem the option item
     */
    SettingFormItem(int questionId, String title, int pos, FormItemStatus status, FormItemReplyType replyType, boolean mustReply, List<FormOptionItem> optionItem) {
        this.questionId = questionId;
        this.title = title;
        this.pos = pos;
        this.status = status;
        this.replyType = replyType;
        this.mustReply = mustReply;
        this.optionItem = optionItem;
    }

    /**
     * Text setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<TextQuestionExtendSetting> text(int questionId,
                                                                  String title,
                                                                  int pos,
                                                                  FormItemStatus status,
                                                                  boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.TEXT,
                mustReply, null);
    }

    /**
     * Radio setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @param optionItem the option item
     * @return the setting form item
     */
    public static SettingFormItem<RadioQuestionExtendSetting> radio(int questionId,
                                                                    String title,
                                                                    int pos,
                                                                    FormItemStatus status,
                                                                    boolean mustReply,
                                                                    List<FormOptionItem> optionItem) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.RADIO,
                mustReply, optionItem);
    }

    /**
     * Checkbox setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @param optionItem the option item
     * @return the setting form item
     */
    public static SettingFormItem<CheckboxQuestionExtendSetting> checkbox(int questionId,
                                                                          String title,
                                                                          int pos,
                                                                          FormItemStatus status,
                                                                          boolean mustReply,
                                                                          List<FormOptionItem> optionItem) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.CHECKBOX,
                mustReply, optionItem);
    }

    /**
     * Location setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<LocationQuestionExtendSetting> location(int questionId,
                                                                          String title,
                                                                          int pos,
                                                                          FormItemStatus status,
                                                                          boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.LOCATION,
                mustReply, null);
    }

    /**
     * Image setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<ImageQuestionExtendSetting> image(int questionId,
                                                                    String title,
                                                                    int pos,
                                                                    FormItemStatus status,
                                                                    boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.IMAGE,
                mustReply, null);
    }

    /**
     * File setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<FileQuestionExtendSetting> file(int questionId,
                                                                  String title,
                                                                  int pos,
                                                                  FormItemStatus status,
                                                                  boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.FILE,
                mustReply, null);
    }

    /**
     * Date setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<DateQuestionExtendSetting> date(int questionId,
                                                                  String title,
                                                                  int pos,
                                                                  FormItemStatus status,
                                                                  boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.DATE,
                mustReply, null);
    }

    /**
     * Time setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<TextQuestionExtendSetting> time(int questionId,
                                                                  String title,
                                                                  int pos,
                                                                  FormItemStatus status,
                                                                  boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.TIME,
                mustReply, null);
    }

    /**
     * Dropdown setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @param optionItem the option item
     * @return the setting form item
     */
    public static SettingFormItem<NullQuestionExtendSetting> dropdown(int questionId,
                                                                      String title,
                                                                      int pos,
                                                                      FormItemStatus status,
                                                                      boolean mustReply,
                                                                      List<FormOptionItem> optionItem) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.DROPDOWN,
                mustReply, optionItem);
    }

    /**
     * Temperature setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<TemperatureQuestionExtendSetting> temperature(int questionId,
                                                                                String title,
                                                                                int pos,
                                                                                FormItemStatus status,
                                                                                boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.TEMPERATURE,
                mustReply, null);
    }

    /**
     * Signature setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<NullQuestionExtendSetting> signature(int questionId,
                                                                       String title,
                                                                       int pos,
                                                                       FormItemStatus status,
                                                                       boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.SIGNATURE,
                mustReply, null);
    }

    /**
     * Department setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<DepartmentQuestionExtendSetting> department(int questionId,
                                                                              String title,
                                                                              int pos,
                                                                              FormItemStatus status,
                                                                              boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.DEPARTMENT,
                mustReply, null);
    }

    /**
     * Member setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<MemberQuestionExtendSetting> member(int questionId,
                                                                      String title,
                                                                      int pos,
                                                                      FormItemStatus status,
                                                                      boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.MEMBER,
                mustReply, null);
    }

    /**
     * Duration setting form item.
     *
     * @param questionId the question id
     * @param title      the title
     * @param pos        the pos
     * @param status     the status
     * @param mustReply  the must reply
     * @return the setting form item
     */
    public static SettingFormItem<DurationQuestionExtendSetting> duration(int questionId,
                                                                          String title,
                                                                          int pos,
                                                                          FormItemStatus status,
                                                                          boolean mustReply) {
        return new SettingFormItem<>(questionId,
                title,
                pos,
                status,
                FormItemReplyType.DURATION,
                mustReply, null);
    }

    /**
     * Note setting form item.
     *
     * @param note the note
     * @return the setting form item
     */
    public SettingFormItem<Q> note(String note) {
        this.note = note;
        return this;
    }

    /**
     * Placeholder setting form item.
     *
     * @param placeholder the placeholder
     * @return the setting form item
     */
    public SettingFormItem<Q> placeholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * Question extend setting setting form item.
     *
     * @param questionExtendSetting the question extend setting
     * @return the setting form item
     */
    public SettingFormItem<Q> questionExtendSetting(Q questionExtendSetting) {
        this.questionExtendSetting = questionExtendSetting;
        return this;
    }
}
