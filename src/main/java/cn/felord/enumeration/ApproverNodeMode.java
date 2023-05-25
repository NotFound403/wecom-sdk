package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ApproverNodeMode {
    OR(1),
    ALL(2);

    private final int mode;

    ApproverNodeMode(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getType() {
        return mode;
    }

    @JsonCreator
    public static ApproverNodeMode deserialize(int mode) {
        return Arrays.stream(ApproverNodeMode.values())
                .filter(contactType -> contactType.mode == mode)
                .findFirst()
                .orElse(null);
    }

}
