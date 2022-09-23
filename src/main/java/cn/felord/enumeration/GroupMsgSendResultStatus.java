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
public enum GroupMsgSendResultStatus {

    /**
     * Unsent msg send status.
     */
    UNSENT(0),
    /**
     * Sent msg send status.
     */
    SENT(1),
    /**
     * Fail due to non friend group msg send result status.
     */
    FAIL_DUE_TO_NON_FRIEND(2),
    /**
     * Has received other msg group msg send result status.
     */
    HAS_RECEIVED_OTHER_MSG(3);

    private final int status;

    GroupMsgSendResultStatus(int status) {
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
    public static GroupMsgSendResultStatus deserialize(int status) {
        return Arrays.stream(GroupMsgSendResultStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
