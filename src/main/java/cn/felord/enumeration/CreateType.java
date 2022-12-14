package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Moment create type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum CreateType {
    /**
     * Corp moment create type.
     */
    CORP(0),
    /**
     * Personal moment create type.
     */
    PERSONAL(1);

    private final int type;

    CreateType(int type) {
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
     * Deserialize moment create type.
     *
     * @param type the type
     * @return the moment create type
     */
    @JsonCreator
    public static CreateType deserialize(int type) {
        return Arrays.stream(CreateType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
