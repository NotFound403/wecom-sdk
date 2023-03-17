package cn.felord.domain.wedoc.form;

import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/3/16 16:27
 */
@Data
public class FormAnswer {
    private List<FormAnswerItem> answerList;
}
