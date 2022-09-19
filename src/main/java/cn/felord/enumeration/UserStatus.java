package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum User status.
 *
 * @author dax
 * @since 2022 /9/17 11:14
 */
public enum UserStatus {

    /**
     * Activated user status.
     */
    ACTIVATED(1),

    /**
     * Disabled user status.
     */
    DISABLED(2),

    /**
     * Inactivated user status.
     */
    INACTIVATED(4),

    /**
     * Quit user status.
     */
    QUIT(5);

    private final int status;

    UserStatus(int status) {
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
     * Deserialize user status.
     *
     * @param status the status
     * @return the user status
     */
    @JsonCreator
    public static UserStatus deserialize(int status) {
        return Arrays.stream(UserStatus.values())
                .filter(userStatus -> userStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
