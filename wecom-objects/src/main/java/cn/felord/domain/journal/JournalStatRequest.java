package cn.felord.domain.journal;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/10/14
 */
@Data
public class JournalStatRequest {
    private final Instant starttime;
    private final Instant endtime;
    private final String templateId;
}