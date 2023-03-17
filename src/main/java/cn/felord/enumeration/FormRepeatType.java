package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 重复类型
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public enum FormRepeatType {

    /**
     * Each day repeat type.
     */
    EACH_DAY(1),
    /**
     * Each week repeat type.
     */
    EACH_WEEK(0),
    /**
     * Each month repeat type.
     */
    EACH_MONTH(2);

    private final int type;

    FormRepeatType(int type) {
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
    public static FormRepeatType deserialize(int type) {
        return Arrays.stream(FormRepeatType.values())
                .filter(boolEnum -> boolEnum.type == type)
                .findFirst()
                .orElse(null);
    }
}
