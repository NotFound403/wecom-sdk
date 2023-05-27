package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * AttendanceType
 *
 * @author dax
 * @since 2023 /5/25 16:19
 */
public enum HolidayType {


    CALENDAR_DAY(0),
    BUSINESS_DAY(1);
    private final int type;

    HolidayType(int type) {
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
    public static HolidayType deserialize(int type) {
        return Arrays.stream(HolidayType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
