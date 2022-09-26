package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 11:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StrategyRangeResponse extends WeComResponse {
    private List<StrategyRange> range;
    private String nextCursor;
}
