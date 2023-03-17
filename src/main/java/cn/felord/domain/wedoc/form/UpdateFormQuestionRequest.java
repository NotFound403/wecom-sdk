package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormOperType;
import lombok.Getter;

/**
 * @author dax
 * @since 2023/3/10 9:35
 */
@Getter
public class UpdateFormQuestionRequest extends AbstractUpdateFormRequest {
    private final String formid;
    private final FormInfo formInfo;

    public UpdateFormQuestionRequest(String formid, String formTitle, String formDesc, String formHeader, FormQuestion formQuestion) {
        super(FormOperType.QUESTION);
        this.formid = formid;
        FormInfo info = new FormInfo(formTitle);
        info.setFormDesc(formDesc);
        info.setFormHeader(formHeader);
        info.setFormQuestion(formQuestion);
        this.formInfo = info;
    }
}
