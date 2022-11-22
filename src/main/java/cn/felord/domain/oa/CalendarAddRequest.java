package cn.felord.domain.oa;

import lombok.Getter;

/**
 * The type Calendar add request.
 *
 * @author felord
 * @since 2022 /11/22 11:19
 */
@Getter
public class CalendarAddRequest {
    private final CalendarBody calendar;
    private final String agentid;

    /**
     * Instantiates a new Calendar add request.
     *
     * @param calendar the calendar
     */
    public CalendarAddRequest(CalendarBody calendar) {
        this(calendar, null);
    }

    /**
     * Instantiates a new Calendar add request.
     *
     * @param calendar the calendar
     * @param agentid  the agentid
     */
    public CalendarAddRequest(CalendarBody calendar, String agentid) {
        this.calendar = calendar;
        this.agentid = agentid;
    }
}
