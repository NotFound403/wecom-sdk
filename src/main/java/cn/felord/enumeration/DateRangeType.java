package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Date ctrl type.
 *
 * @author dax
 * @since 2023 /5/25 16:19
 */
public enum DateRangeType {

    /**
     * Day date ctrl type.
     */
    HALF_DAY("halfday"),
    /**
     * Hour date ctrl type.
     */
    HOUR("hour");
    private final String type;

    DateRangeType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }


    /**
     * Deserialize date ctrl type.
     *
     * @param type the type
     * @return the date ctrl type
     */
    @JsonCreator
    public static DateRangeType deserialize(String type) {
        return Arrays.stream(DateRangeType.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
