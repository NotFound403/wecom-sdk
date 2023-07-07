package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

/**
 * @author dax
 * @since 2023/7/7 8:45
 */
@Data
public class MchIdAndOutRefundNo {
    private final String mchid;
    private final String outRefundNo;
}
