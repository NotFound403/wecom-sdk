package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 部门问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class DepartmentQuestionExtendSetting implements QuestionExtendSetting {
    private AllowMultipleSelection departmentSetting;
}
