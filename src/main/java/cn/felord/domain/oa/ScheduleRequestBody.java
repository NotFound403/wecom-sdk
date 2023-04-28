package cn.felord.domain.oa;

import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
public class ScheduleRequestBody {
    private final Instant startTime;
    private final Instant endTime;
    private Set<String> admins;
    private List<AttendeesItem> attendees;
    private String summary;
    private String description;
    private Reminders reminders;
    private String calId;
    private String location;
}