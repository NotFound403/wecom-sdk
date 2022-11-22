package cn.felord.domain.oa;

import cn.felord.enumeration.ScheduleOpMode;
import lombok.Getter;

import java.time.Instant;

@Getter
public class ScheduleDelRequest {
    private final String scheduleId;
    private final ScheduleOpMode opMode;
    private final Instant opStartTime;

    public ScheduleDelRequest(String scheduleId) {
        this(scheduleId, null, null);
    }

    public ScheduleDelRequest(String scheduleId, ScheduleOpMode opMode) {
        this(scheduleId, opMode, null);
    }

    public ScheduleDelRequest(String scheduleId, Instant opStartTime) {
        this(scheduleId, null, opStartTime);
    }

    public ScheduleDelRequest(String scheduleId, ScheduleOpMode opMode, Instant opStartTime) {
        this.scheduleId = scheduleId;
        this.opMode = opMode;
        this.opStartTime = opStartTime;
    }
}