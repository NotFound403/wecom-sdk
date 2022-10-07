package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Moment visible type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum MomentVisibleType {
    /**
     * Partial moment visible type.
     */
    PARTIAL(0),
    /**
     * Whole moment visible type.
     */
    WHOLE(1);

    private final int type;

    MomentVisibleType(int type) {
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
     * Deserialize moment visible type.
     *
     * @param type the type
     * @return the moment visible type
     */
    @JsonCreator
    public static MomentVisibleType deserialize(int type) {
        return Arrays.stream(MomentVisibleType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
