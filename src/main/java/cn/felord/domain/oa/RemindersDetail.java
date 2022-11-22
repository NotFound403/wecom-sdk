package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.RemindBeforeEventSecs;
import cn.felord.enumeration.RepeatType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author felord
 * @since 2022/11/21 17:41
 */
@Data
public class RemindersDetail {
    private BoolEnum isRemind;
    private BoolEnum isRepeat;
    private RemindBeforeEventSecs remindBeforeEventSecs;
    private List<Integer> remindTimeDiffs;
    private RepeatType repeatType;
    private Instant repeatUntil;
    private BoolEnum isCustomRepeat;
    private Integer repeatInterval;
    private List<Integer> repeatDayOfWeek;
    private List<Integer> repeatDayOfMonth;
    private Integer timezone;
    private List<ExcludeTime> excludeTimeList;
}
