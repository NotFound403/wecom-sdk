package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/7/12 11:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentStrategyDetailResponse extends WeComResponse {
    private MomentStrategyDetail strategy;
}
