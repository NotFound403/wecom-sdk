package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 单选问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class RadioQuestionExtendSetting implements QuestionExtendSetting {
    private RadioSetting radioSetting;
}
