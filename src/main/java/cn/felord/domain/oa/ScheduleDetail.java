package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ScheduleStatus;

import java.time.Instant;
import java.util.List;

/**
 * @author xiafang
 * @since 2022/11/21 17:09
 */
public class ScheduleDetail {
    private String scheduleId;
    private String organizer;
    private List<AttendeeDetail> attendees;
    private String summary;
    private String description;
    private Reminders reminders;
    private String location;
    private String calId;
    private Instant startTime;
    private Instant endTime;
    private Boolean allowActiveJoin;
    private BoolEnum onlyOrganizerCreateChat;
    private ScheduleStatus status;
}
