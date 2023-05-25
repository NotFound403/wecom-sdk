package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Approval notify type.
 *
 * @author dax
 * @since 2023 /5/26
 */
public enum ApprovalNotifyType {
    /**
     * When submitting approval notify type.
     */
    WHEN_SUBMITTING(1),
    /**
     * When passing approval notify type.
     */
    WHEN_PASSING(2),
    /**
     * When both approval notify type.
     */
    WHEN_BOTH(2);

    private final int type;

    ApprovalNotifyType(int type) {
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
     * Deserialize approval notify type.
     *
     * @param type the type
     * @return the approval notify type
     */
    @JsonCreator
    public static ApprovalNotifyType deserialize(int type) {
        return Arrays.stream(ApprovalNotifyType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
