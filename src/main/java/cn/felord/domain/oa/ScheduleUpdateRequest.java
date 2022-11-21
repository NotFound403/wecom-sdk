package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ScheduleOpMode;
import lombok.Data;

import java.time.Instant;

@Data
public class ScheduleUpdateRequest {
    private BoolEnum skipAttendees;
    private ScheduleOpMode opMode;
    private Instant opStartTime;
    private final ScheduleUpdateBody schedule;
}