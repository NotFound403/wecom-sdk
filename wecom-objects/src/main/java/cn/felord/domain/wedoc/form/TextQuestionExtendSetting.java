package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 文本问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class TextQuestionExtendSetting implements QuestionExtendSetting {
    private TextSetting textSetting;
}
