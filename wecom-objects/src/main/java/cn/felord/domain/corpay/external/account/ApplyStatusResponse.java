package cn.felord.domain.corpay.external.account;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.ApplyState;
import cn.felord.enumeration.RealSignState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/7/3 16:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApplyStatusResponse extends WeComResponse {
    private AccountStatusInfo status;
    private ApplyState applyState;
    private RealSignState realSignState;
    private String rejectReason;
}
