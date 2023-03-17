package cn.felord.domain.office.form;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/3/16 11:34
 */
@Data
public class FormDetail {
    private String formid;
    private String formTitle;
    private String formDesc;
    private String formHeader;
    private FormQuestion formQuestion;
    private FormSettingDetail formSetting;

    private List<String> repeatedId;
}
