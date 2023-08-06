package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormCheckboxType;
import lombok.Data;

/**
 * @author dax
 * @since 2023/8/4 13:57
 */
@Data
public class CheckboxSetting {
    private Boolean addOtherOption;
    private FormCheckboxType type;
    private Integer number;
}
