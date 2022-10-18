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
public enum BoolEnum {

    /**
     * False bool enum.
     */
    FALSE(0),
    /**
     * True bool enum.
     */
    TRUE(1);

    private final int type;

    BoolEnum(int type) {
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
    public static BoolEnum deserialize(int type) {
        return Arrays.stream(BoolEnum.values())
                .filter(boolEnum -> boolEnum.type==type)
                .findFirst()
                .orElse(null);
    }
}
