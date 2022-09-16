package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ContactUserTagType {
    CORP_SETTINGS(1),
    CUSTOM(2),
    RULE_GROUP(3);

    private final int type;

    ContactUserTagType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static ContactUserTagType deserialize(int type) {
        return Arrays.stream(ContactUserTagType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
