package cn.felord.domain.callcenter;

import lombok.Data;

import java.time.Instant;

/**
 * @author xiafang
 * @since 2023/6/7 15:37
 */
@Data
public class KfServicerStatisticRequest {
    private final Instant startTime;
    private final Instant endTime;
    private String openKfid;
    private String servicerUserid;
}
