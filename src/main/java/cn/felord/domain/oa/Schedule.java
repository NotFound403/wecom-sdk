package cn.felord.domain.oa;

import java.time.Instant;
import java.util.List;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

@Data
public class Schedule{
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