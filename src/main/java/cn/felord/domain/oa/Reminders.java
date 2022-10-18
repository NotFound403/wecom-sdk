package cn.felord.domain.oa;

import java.time.Instant;
import java.util.List;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.RemindBeforeEventSecs;
import cn.felord.enumeration.RepeatType;
import lombok.Data;

@Data
public class Reminders{
	private BoolEnum isRemind;
	private BoolEnum isRepeat;
	private RemindBeforeEventSecs remindBeforeEventSecs;
	private RepeatType repeatType;
	private Integer timezone;
	private Instant repeatUntil;
	private Integer repeatInterval;
	private List<Integer> repeatDayOfMonth;
	private List<Integer> repeatDayOfWeek;
	private BoolEnum isCustomRepeat;
}