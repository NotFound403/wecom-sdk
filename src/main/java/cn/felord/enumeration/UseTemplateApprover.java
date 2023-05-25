package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum UseTemplateApprover {
    APPROVER_MODE(0),
    BACKEND_MODE(1);

    private final int type;

    UseTemplateApprover(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static UseTemplateApprover deserialize(int type) {
        return Arrays.stream(UseTemplateApprover.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
