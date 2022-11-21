package cn.felord.domain.oa;

import lombok.Getter;

import java.time.Instant;

/**
 * @author xiafang
 * @since 2022/11/21 15:46
 */
@Getter
public class ScheduleUpdateBody extends ScheduleRequestBody {
    private final String scheduleId;

    public ScheduleUpdateBody(String scheduleId, String organizer, Instant startTime, Instant endTime) {
        super(organizer, startTime, endTime);
        this.scheduleId = scheduleId;
    }
}
