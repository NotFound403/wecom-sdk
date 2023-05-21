package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Share permission.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum SharePermission {
    /**
     * Read all share permission.
     */
    READ_ALL(1),
    /**
     * Read status share permission.
     */
    READ_STATUS(3);

    private final int type;

    SharePermission(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize share permission.
     *
     * @param type the type
     * @return the share permission
     */
    @JsonCreator
    public static SharePermission deserialize(int type) {
        return Arrays.stream(SharePermission.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
