package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author xiafang
 * @since 2022/9/21 15:24
 */
@Data
public class StrategyRangeRequest {
    private final Integer strategyId;
    private String cursor;
    private Integer limit;
}
