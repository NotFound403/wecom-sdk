package cn.felord.domain.oa;

import lombok.Data;

import java.util.Set;

/**
 * @author xiafang
 * @since 2022/11/21 15:56
 */
@Data
public class ScheduleAttendees {
    private final String scheduleId;
    private final Set<AttendeesItem> attendees;
}
