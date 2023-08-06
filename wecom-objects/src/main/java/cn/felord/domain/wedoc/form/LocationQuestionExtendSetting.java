package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 位置问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class LocationQuestionExtendSetting implements QuestionExtendSetting {
    private LocationSetting locationSetting;
}
