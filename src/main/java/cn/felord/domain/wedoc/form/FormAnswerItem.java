package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.AnswerStatus;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/16 15:36
 */
@Data
public class FormAnswerItem {
    private Long answerId;
    private String userName;
    private Instant ctime;
    private Instant mtime;
    private AnswerReply reply;
    private AnswerStatus answerStatus;
    private String tmpExternalUserid;
}
