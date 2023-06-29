package cn.felord.domain.corpay.external;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/29 15:30
 */
@Data
public class BillRequest {
    private final Instant beginTime;
    private final Instant endTime;
    private String payeeUserid;
    private String cursor;
    private Integer limit;
}
