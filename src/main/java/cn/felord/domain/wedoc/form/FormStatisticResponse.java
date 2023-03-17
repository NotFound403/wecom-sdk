package cn.felord.domain.wedoc.form;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/3/16 13:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormStatisticResponse extends WeComResponse {
    private Integer fillCnt;
    private Integer fillUserCnt;
    private Integer unfillUserCnt;

}
