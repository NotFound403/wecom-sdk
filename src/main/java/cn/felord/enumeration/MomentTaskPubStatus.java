package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The MomentTaskPubStatus
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum MomentTaskPubStatus {

    /**
     * Unpublished moment task pub status.
     */
    UNPUBLISHED(0),

    /**
     * Published moment task pub status.
     */
    PUBLISHED(1) ;

    private final int status;

    MomentTaskPubStatus(int status) {
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
    public static MomentTaskPubStatus deserialize(int status) {
        return Arrays.stream(MomentTaskPubStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
