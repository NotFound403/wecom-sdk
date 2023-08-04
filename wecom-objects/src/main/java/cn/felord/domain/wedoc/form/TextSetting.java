package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.TextValidationDetail;
import cn.felord.enumeration.TextValidationType;
import lombok.Data;

/**
 * Form文本额外校验
 *
 * @author dax
 * @since 2023 /8/4 11:46
 */
@Data
public class TextSetting {
    private TextValidationType validationType;
    private TextValidationDetail validationDetail;
    private Integer charLen;
    private Long numberMin;
    private Long numberMax;
}
