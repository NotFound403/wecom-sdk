package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum RangeType {
    USER(1),
    PARTY(2);

    private final int type;

    RangeType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static RangeType deserialize(int type) {
        return Arrays.stream(RangeType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
