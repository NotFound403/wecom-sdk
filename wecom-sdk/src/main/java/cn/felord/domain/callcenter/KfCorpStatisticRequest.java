package cn.felord.domain.callcenter;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/6/7 15:37
 */
@Data
public class KfCorpStatisticRequest {
    private final Instant startTime;
    private final Instant endTime;
    private String openKfid;
}
