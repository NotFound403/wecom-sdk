package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ContactType {
    SINGLE(1),
    MULTI(2);

    private final int type;

    ContactType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static ContactType deserialize(int type) {
        return Arrays.stream(ContactType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
