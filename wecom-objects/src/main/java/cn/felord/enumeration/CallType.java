package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Call type.
 *
 * @author dax
 * @since 2023 /10/6
 */
public enum CallType {
    /**
     * 单人通话
     */
    SINGLE(1),
    /**
     * 多人通话
     */
    MULTI(2);

    private final int type;

    CallType(int type) {
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
     * Deserialize call type.
     *
     * @param type the type
     * @return the approval notify type
     */
    @JsonCreator
    public static CallType deserialize(int type) {
        return Arrays.stream(CallType.values())
                .filter(callType -> callType.type == type)
                .findFirst()
                .orElse(null);
    }
}
