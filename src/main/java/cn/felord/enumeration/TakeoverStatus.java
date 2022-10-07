package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Takeover status.
 *
 * @author dax
 * @since 2021/9/14 14:44
 */
public enum TakeoverStatus {
    /**
     * Finished takeover status.
     */
    FINISHED(1),
    /**
     * Pending takeover status.
     */
    PENDING(2),
    /**
     * Refused takeover status.
     */
    REFUSED(3),
    /**
     * Exceeded takeover status.
     */
    EXCEEDED(4);

    private final int status;

    TakeoverStatus(int status) {
        this.status = status;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize takeover status.
     *
     * @param status the status
     * @return the takeover status
     */
    @JsonCreator
    public static TakeoverStatus deserialize(int status) {
        return Arrays.stream(TakeoverStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
