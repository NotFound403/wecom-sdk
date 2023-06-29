package cn.felord.domain.corpay.external;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/29 15:30
 */
@Data
public class FundFlowRequest {
    private final Instant beginTime;
    private final Instant endTime;
    private String mchId;
    private String cursor;
    private Integer limit;
}
