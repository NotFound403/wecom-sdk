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


    UNTREATED(0),

    CANCEL(1);

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
