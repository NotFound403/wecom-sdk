package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ScheduleRequestBody {
    private final String organizer;
    private final Instant startTime;
    private final Instant endTime;
    private List<AttendeesItem> attendees;
    private String summary;
    private String description;
    private Reminders reminders;
    private String calId;
    private String location;
    private Boolean allowActiveJoin;
	private BoolEnum onlyOrganizerCreateChat;
}