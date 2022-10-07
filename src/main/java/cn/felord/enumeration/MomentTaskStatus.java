package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Moment task status.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum MomentTaskStatus {
    /**
     * Begin moment task status.
     */
    BEGIN(1),
    /**
     * Pending moment task status.
     */
    PENDING(2),
    /**
     * Finished moment task status.
     */
    FINISHED(3);

    private final int status;

    MomentTaskStatus(int status) {
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
    public static MomentTaskStatus deserialize(int status) {
        return Arrays.stream(MomentTaskStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
