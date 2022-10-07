package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Range type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum RangeType {
    /**
     * User range type.
     */
    USER(1),
    /**
     * Party range type.
     */
    PARTY(2);

    private final int type;

    RangeType(int type) {
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
     * Deserialize range type.
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static RangeType deserialize(int type) {
        return Arrays.stream(RangeType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
