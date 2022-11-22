package cn.felord.domain.oa;

import lombok.Data;

/**
 * The type Calendar query.
 *
 * @author felord
 * @since 2022 /11/22 9:46
 */
@Data
public class ScheduleCalendarQuery {
    private final String calId;
    private final Long offset;
    private final Integer limit;

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId the cal id
     */
    public ScheduleCalendarQuery(String calId) {
        this(calId, null, null);
    }

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId  the cal id
     * @param offset the offset
     */
    public ScheduleCalendarQuery(String calId, Long offset) {
        this(calId, offset, null);
    }

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId the cal id
     * @param limit the limit
     */
    public ScheduleCalendarQuery(String calId, Integer limit) {
        this(calId, null, limit);
    }

    /**
     * Instantiates a new Calendar query.
     *
     * @param calId  the cal id
     * @param offset the offset
     * @param limit  the limit
     */
    public ScheduleCalendarQuery(String calId, Long offset, Integer limit) {
        this.calId = calId;
        this.offset = offset;
        this.limit = limit;
    }
}
