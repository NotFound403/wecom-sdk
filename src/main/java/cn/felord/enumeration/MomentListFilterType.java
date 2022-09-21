package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Moment list filter type.
 *
 * @author dax
 * @since 2022 /9/19 17:47
 */
public enum MomentListFilterType {
    /**
     * Corp moment list filter type.
     */
    CORP(0),
    /**
     * Personal moment list filter type.
     */
    PERSONAL(1),
    /**
     * Whole moment list filter type.
     */
    WHOLE(2);

    private final int type;

    MomentListFilterType(int type) {
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
     * Deserialize moment list filter type.
     *
     * @param type the type
     * @return the moment list filter type
     */
    @JsonCreator
    public static MomentListFilterType deserialize(int type) {
        return Arrays.stream(MomentListFilterType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
