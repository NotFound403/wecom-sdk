package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormOperType;
import lombok.Getter;

/**
 * @author dax
 * @since 2023/3/16 11:24
 */
@Getter
public class UpdateFormSettingRequest extends AbstractUpdateFormRequest {
    private final String formid;
    private final FormInfo formInfo;

    protected UpdateFormSettingRequest(String formid, FormSetting formSetting) {
        super(FormOperType.SETTING);
        this.formid = formid;
        FormInfo info = new FormInfo(null);
        info.setFormSetting(formSetting);
        this.formInfo = info;
    }


}
