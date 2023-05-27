package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import lombok.Data;

/**
 * TODO
 *
 * @author dax
 * @since 2023/5/26
 */
@Data
public class TemplateContentData<V extends ContentDataValue> {
    private final ApprovalCtrlType control;
    private final String id;
    private final V value;
}
