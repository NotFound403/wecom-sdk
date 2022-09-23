package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/21 15:24
 */
@Data
public class StrategyRangeRequest {
    private final Integer strategyId;
    private String cursor;
    private Integer limit;
}
