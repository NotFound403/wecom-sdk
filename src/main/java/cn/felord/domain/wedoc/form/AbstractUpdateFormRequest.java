package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormOperType;
import lombok.Getter;

/**
 * @author dax
 * @since 2023/3/16 10:47
 */
@Getter
public abstract class AbstractUpdateFormRequest {
    private final FormOperType oper;

    protected AbstractUpdateFormRequest(FormOperType oper) {
        this.oper = oper;
    }
}
