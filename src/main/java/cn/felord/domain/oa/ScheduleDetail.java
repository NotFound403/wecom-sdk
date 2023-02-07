package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ScheduleStatus;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author felord
 * @since 2021/11/21 17:09
 */
@Data
public class ScheduleDetail {
    private String scheduleId;
    private Long sequence;
    private String organizer;
    private List<AttendeeDetail> attendees;
    private String summary;
    private String description;
    private RemindersDetail reminders;
    private String location;
    private String calId;
    private Instant startTime;
    private Instant endTime;
    private Boolean allowActiveJoin;
    private BoolEnum onlyOrganizerCreateChat;
    private ScheduleStatus status;
}
