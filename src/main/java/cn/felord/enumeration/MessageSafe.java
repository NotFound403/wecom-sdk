package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Bool enum.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public enum MessageSafe {

    /**
     * False bool enum.
     */
    SHARED(0),
    /**
     * True bool enum.
     */
    UN_SHARED(1);

    private final int type;

    MessageSafe(int type) {
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
     * Deserialize bool enum.
     *
     * @param type the type
     * @return the bool enum
     */
    @JsonCreator
    public static MessageSafe deserialize(int type) {
        return Arrays.stream(MessageSafe.values())
                .filter(boolEnum -> boolEnum.type == type)
                .findFirst()
                .orElse(null);
    }
}
