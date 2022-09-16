package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ContactUserType {
    WECHAT(1),
    WORK_WECHAT(2);

    private final int type;

    ContactUserType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static ContactUserType deserialize(int type) {
        return Arrays.stream(ContactUserType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
