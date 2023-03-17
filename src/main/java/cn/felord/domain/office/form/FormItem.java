package cn.felord.domain.office.form;

import cn.felord.enumeration.FormItemReplyType;
import cn.felord.enumeration.FormItemStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author dax
 * @since 2023/3/13 16:34
 */
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


    public FormItem(int questionId,
                    String title,
                    int pos,
                    FormItemStatus status,
                    FormItemReplyType replyType,
                    boolean mustReply) {
        this(questionId, title, pos, status, replyType, mustReply, null, null, null);
    }

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
