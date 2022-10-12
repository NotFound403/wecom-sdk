package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 11:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StrategyListResponse extends CursorWeComResponse {
    private List<StrategyId> strategy;

    @Data
    public static class StrategyId {
        private Integer strategyId;
    }
}
