package cn.felord.domain.approval;

import cn.felord.enumeration.DateRangeType;
import cn.felord.enumeration.HolidayType;
import lombok.Data;

import java.time.Duration;

/**
 * @author dax
 * @since 2023/5/25 18:26
 */
@Data
public class DateRange {
    private DateRangeType type;
    private HolidayType officialHoliday;
    private Duration perdayDuration;
}
