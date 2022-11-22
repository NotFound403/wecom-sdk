package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The MomentTaskPubStatus
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum ScheduleAttendeeResponseStatus {

    /**
     * Untreated schedule attendee response status.
     */
    UNTREATED(0),
    /**
     * Cancel schedule attendee response status.
     */
    CANCEL(1),
    /**
     * All schedule attendee response status.
     */
    ALL(2),
    /**
     * Once schedule attendee response status.
     */
    ONCE(3),
    /**
     * Refused schedule attendee response status.
     */
    REFUSED(4),
    ;

    private final int status;

    ScheduleAttendeeResponseStatus(int status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize moment task status.
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static ScheduleAttendeeResponseStatus deserialize(int status) {
        return Arrays.stream(ScheduleAttendeeResponseStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
