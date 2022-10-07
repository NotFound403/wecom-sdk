package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Moment interaction type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum MomentInteractionType {
    /**
     * External moment interaction type.
     */
    EXTERNAL(1),
    /**
     * Internal moment interaction type.
     */
    INTERNAL(2);

    private final int type;

    MomentInteractionType(int type) {
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
     * Deserialize moment interaction type.
     *
     * @param type the type
     * @return the moment interaction type
     */
    @JsonCreator
    public static MomentInteractionType deserialize(int type) {
        return Arrays.stream(MomentInteractionType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
