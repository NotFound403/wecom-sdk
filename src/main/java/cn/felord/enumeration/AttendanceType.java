package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * AttendanceType
 *
 * @author xiafang
 * @since 2023 /5/25 16:19
 */
public enum AttendanceType {


    LEAVE(1),
    BUSINESS_TRIP(3),
    GOING_OUT(4),
    OVERTIME_WORK(5);
    private final int type;

    AttendanceType(int type) {
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
     * Deserialize date ctrl type.
     *
     * @param type the type
     * @return the date ctrl type
     */
    @JsonCreator
    public static AttendanceType deserialize(int type) {
        return Arrays.stream(AttendanceType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
