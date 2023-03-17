package cn.felord.domain.office.form;

import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/3/16 16:25
 */
@Data
public class AnswerReply {
    private List<AnswerReplyItem> items;
}
