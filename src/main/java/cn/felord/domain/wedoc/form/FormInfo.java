package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * @author dax
 * @since 2023/3/13 16:32
 */
@Data
public class FormInfo {
    private final String formTitle;
    private String formDesc;
    private String formHeader;
    private FormQuestion formQuestion;
    private FormSetting formSetting;
}
