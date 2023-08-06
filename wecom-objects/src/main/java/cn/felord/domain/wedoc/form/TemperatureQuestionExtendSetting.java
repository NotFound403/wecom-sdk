package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 温度问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class TemperatureQuestionExtendSetting implements QuestionExtendSetting {
    private TemperatureSetting temperatureSetting;
}
