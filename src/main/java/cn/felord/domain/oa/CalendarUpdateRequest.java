package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;

/**
 * The type Calendar update request.
 *
 * @author felord
 * @since 2021 /11/22 11:37
 */
@Getter
public class CalendarUpdateRequest {
    private final BoolEnum skipPublicRange;
    private final CalendarUpdateBody calendar;

    /**
     * Instantiates a new Calendar update request.
     *
     * @param calendar the calendar
     */
    public CalendarUpdateRequest(CalendarUpdateBody calendar) {
        this(BoolEnum.FALSE, calendar);
    }

    /**
     * Instantiates a new Calendar update request.
     *
     * @param skipPublicRange the skip public range
     * @param calendar        the calendar
     */
    public CalendarUpdateRequest(BoolEnum skipPublicRange, CalendarUpdateBody calendar) {
        this.skipPublicRange = skipPublicRange;
        this.calendar = calendar;
    }
}
