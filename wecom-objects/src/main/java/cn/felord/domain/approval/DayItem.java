package cn.felord.domain.approval;

import lombok.Data;

import java.time.Duration;
import java.time.Instant;

/**
 * @author dax
 * @since 2023/12/19
 */
@Data
public class DayItem {
    private Instant daytime;
    private Duration duration;
}
