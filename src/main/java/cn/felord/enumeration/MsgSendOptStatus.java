package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Moment task status.
 *
 * @author dax
 * @since 2021 /4/18 10:47
 */
public enum MsgSendOptStatus {

    /**
     * Unsent msg send status.
     */
    UNSENT(0),

    /**
     * Sent msg send status.
     */
    SENT(2);

    private final int status;

    MsgSendOptStatus(int status) {
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
    public static MsgSendOptStatus deserialize(int status) {
        return Arrays.stream(MsgSendOptStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
