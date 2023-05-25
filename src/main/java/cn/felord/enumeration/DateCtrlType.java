package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Date ctrl type.
 *
 * @author xiafang
 * @since 2023 /5/25 16:19
 */
public enum DateCtrlType {

    /**
     * Day date ctrl type.
     */
    DAY("day"),
    /**
     * Hour date ctrl type.
     */
    HOUR("hour");
    private final String type;

    DateCtrlType(String type) {
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
    public static DateCtrlType deserialize(String type) {
        return Arrays.stream(DateCtrlType.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
