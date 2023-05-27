package cn.felord.domain.wedoc.form;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/3/16 16:27
 */
@Data
public class FormAnswer {
    private List<FormAnswerItem> answerList;
}
