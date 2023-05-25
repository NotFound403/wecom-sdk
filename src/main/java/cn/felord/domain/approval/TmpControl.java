package cn.felord.domain.approval;

import lombok.Data;

/**
 * 控件
 *
 * @author xiafang
 * @since 2023/5/25 14:42
 */
@Data
public class TmpControl<C> {
    private final CtrlProperty property;
    private C config;


}
