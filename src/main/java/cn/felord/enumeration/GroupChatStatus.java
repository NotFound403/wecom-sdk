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
public enum GroupChatStatus {

    /**
     * Normal group chat status.
     */
    NORMAL(0),

    /**
     * Waiting group chat status.
     */
    WAITING(1),

    /**
     * Pending group chat status.
     */
    PENDING(2),

    /**
     * Finished group chat status.
     */
    FINISHED(3);

    private final int status;

    GroupChatStatus(int status) {
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
    public static GroupChatStatus deserialize(int status) {
        return Arrays.stream(GroupChatStatus.values())
                .filter(contactScene -> contactScene.status == status)
                .findFirst()
                .orElse(null);
    }
}
