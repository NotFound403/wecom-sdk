package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 11:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerStrategyRangeResponse extends WeComResponse {
    private Set<CustomerStrategyRange> range;
    private String nextCursor;
}
