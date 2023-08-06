package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 时间问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class TimeQuestionExtendSetting implements QuestionExtendSetting {
    private TimeSetting timeSetting;
}
