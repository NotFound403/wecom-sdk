package cn.felord.domain.dial;

import lombok.Data;

import java.time.Instant;

@Data
public class DialRecordsRequest {
    private Instant startTime;
    private Instant endTime;
    private Long offset;
    private Integer limit;
}