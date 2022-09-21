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
public class StrategyListResponse extends WeComResponse {
    private Set<StrategyId> strategy;
    private String nextCursor;

    @Data
    public static class StrategyId {
        private Integer strategyId;
    }
}
