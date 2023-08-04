package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * 文件问题的额外设置
 *
 * @author dax
 * @since 2023/8/4 10:58
 */
@Data
public class FileQuestionExtendSetting implements QuestionExtendSetting {
    private FileSetting fileSetting;
}
